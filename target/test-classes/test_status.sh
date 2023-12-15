#!/usr/bin/bash

TEST_RESULTS_REPORT=$1
echo "Output Repository is $TEST_RESULTS_REPORT"
TEST_REPORT=$(cat "$TEST_RESULTS_REPORT" | grep "<testng-results")
SUITE=$(awk '/suite/ { print $0 }' "$TEST_RESULTS_REPORT")


cat << EOF | curl --data-binary @- http://${PUSHGATEWAY_IP}:9091/metrics/job/results
selenium_ignored_tests{action_id="${GITHUB_RUN_NUMBER}", author="${GITHUB_ACTOR}", os="${RUNNER_OS}"} $(echo ${TEST_REPORT} | awk -F'"' '{ print $2 }')
selenium_total_tests{action_id="${GITHUB_RUN_NUMBER}", author="${GITHUB_ACTOR}", os="${RUNNER_OS}"} $(echo ${TEST_REPORT} | awk -F'"' '{ print $4 }')
selenium_total_tests_passed{action_id="${GITHUB_RUN_NUMBER}", author="${GITHUB_ACTOR}", os="${RUNNER_OS}"} $(echo ${TEST_REPORT} | awk -F'"' '{ print $6 }')
selenium_total_tests_failed{action_id="${GITHUB_RUN_NUMBER}", author="${GITHUB_ACTOR}", os="${RUNNER_OS}"} $(echo ${TEST_REPORT} | awk -F'"' '{ print $8 }')
selenium_total_tests_skipped{action_id="${GITHUB_RUN_NUMBER}", author="${GITHUB_ACTOR}", os="${RUNNER_OS}"} $(echo ${TEST_REPORT} | awk -F'"' '{ print $10 }')
selenium_suite_execution_duration{action_id="${GITHUB_RUN_NUMBER}", author="${GITHUB_ACTOR}", os="${RUNNER_OS}"} $(echo ${SUITE} | awk -F'"' '{ print $8 }')
EOF
