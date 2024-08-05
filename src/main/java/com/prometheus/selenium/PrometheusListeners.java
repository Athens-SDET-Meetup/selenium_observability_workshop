package com.prometheus.selenium;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;
import pl.mjaron.tinyloki.ILogStream;
import pl.mjaron.tinyloki.LogController;
import pl.mjaron.tinyloki.TinyLoki;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class PrometheusListeners implements ITestListener {

    private LogController logController = TinyLoki
        .withUrl("http://localhost:3100/loki/api/v1/push")
        .start();

    private ILogStream stream = logController.stream()
        .info()
        .l("conference", "AutomationStar")
        .build();


    List<String> labelKeys = Arrays.asList("author");
    List<String> labelValues = Arrays.asList("gpapadakis");

    PushGateway client = new PushGateway("localhost:9091");
    CollectorRegistry registry = CollectorRegistry.defaultRegistry;

    String jobName = "selenium";
    String passed = "TestPassed";
    String failed = "TestFailed";
    String skipped = "TestSkipped";
    String help = "metric_help";

    Gauge passedTests = Gauge.build()
            .name(passed)
            .help(help)
            .labelNames(labelKeys.toArray(new String[0]))
            .register(registry);

    Gauge failedTests = Gauge.build()
            .name(failed)
            .help(help)
            .labelNames(labelKeys.toArray(new String[0]))
            .register(registry);

    Gauge skippedTests = Gauge.build()
            .name(skipped)
            .help(help)
            .labelNames(labelKeys.toArray(new String[0]))
            .register(registry);

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        passedTests.labels(labelValues.toArray(new String[0])).inc();
        stream.log(String.format("Successful test %s", result.getName()));
        try {
            client.push(registry, jobName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests.labels(labelValues.toArray(new String[0])).inc();
        stream.log(String.format("Failed test %s", result.getName()));
        try {
            client.push(registry, jobName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests.labels(labelValues.toArray(new String[0])).inc();
        stream.log(String.format("Skipped test %s", result.getName()));
        try {
            client.push(registry, jobName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        logController.softStop().hardStop();
    }

}
