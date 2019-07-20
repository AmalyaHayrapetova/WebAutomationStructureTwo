package utilities;

import org.apache.log4j.Logger;
import org.testng.*;

public class AutomationListener implements ITestListener, IInvokedMethodListener {
    private static final Logger LOGGER = Logger.getLogger(AutomationListener.class);


    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("Starting to run " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("PASSED " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("FAILED " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("SKIPPED " + iTestResult.getMethod().getQualifiedName() + " test method");
        LOGGER.info("----------------------------------------------------------------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext context) {
        LOGGER.info("Staring to run test suite with " + context.getAllTestMethods().length + " tests");
//        report = context;
//        for (ITestNGMethod m1 : context.getAllTestMethods()) {
//            if (m1.getConstructorOrMethod().getMethod().isAnnotationPresent(TestCaseData.class)) {
//                //capture metadata information.
//                testCaseId = m1.getConstructorOrMethod().getMethod().getAnnotation(TestCaseData.class).testKey();
//                res.put(m1.getRealClass().getName() + "_" + m1.getMethodName(), testCaseId);
//            }
//        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        System.out.println("fin");
//        list.printTestList();
//        object.add("testData", list.getTestResultsInJsonData());
//        BuildProperty buildProperty = new BuildProperty();
//        object.addProperty("projectKey", "PIA");
//        object.addProperty("projectId", "12101");
//        object.addProperty("versionId", "29542");
//        object.addProperty("cycleId", "null");
//        try {
//            ReadWriteFile.writeInFile(testReport, object);
//        } catch (IOException e) {
//            testReportDir.mkdirs();
//            try {
//                ReadWriteFile.writeInFile(testReport, object);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//            e.printStackTrace();
//        }
//    }


//    @Override
//    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
//        String name = iInvokedMethod.getTestMethod().getRealClass().getName() + "_" + iInvokedMethod.getTestMethod().getMethodName();
//        if (res.containsKey(name)) {
//            String testName = iInvokedMethod.getTestMethod().getMethodName();
//            String testClassName = iInvokedMethod.getTestMethod().getRealClass().getName();
//            String testCaseId = res.get(name);
//            testCase = new TestCase(testName, testClassName, testCaseId);
//        }
//    }

//    @Override
//    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
//        if (testCase != null && testCase.getTestName().equals(iInvokedMethod.getTestMethod().getMethodName())) {
//            try {
//                testCase.testEnd();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            testCase.setStatus(iTestResult.getStatus());
//            list.setTestObj(testCase);
//            testCase = null;
//        }

//    }

}
