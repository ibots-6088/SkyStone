package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

@Autonomous(name="AutonomousRed", group="Autonomous")
//@Disabled
public class AutonomousRed extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lf;
    private DcMotor rf;
    private DcMotor lb;
    private DcMotor rb;
    private DcMotorEx vt;
    private Servo atmt;
    private DcMotorEx liftL;
    private DcMotorEx liftR;
    private static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Stone";
    private static final String LABEL_SECOND_ELEMENT = "Skystone";
    private static final String VUFORIA_KEY =
            "ASHE5an/////AAABmZz09E/aWUWnt8ZyGO7Alj0kRvzin8IO8K1Nb0WUinKpgoIKfzmoMrq2D25qvsuUM4hcYLqkUS836SvznXp3BdwnryrcwwJTpbMZhtuZedPV32TudRnSn3xz4bPzQ3ysYefUlV45yy98H4v2XyeE8GHPiAOfbqoRDuYvEMb3stpJhI725n+NwRuE5jG9moTaSA4tuByRAZLSW6oyHwRR4TU5YzZHKQbFnLKR6Y33FnwHbI2aN015Xau10JWO+qXlA0F1qvkKMraQYL3HjmqX6JhSetjKK9iKKnwunuRmeLR4HrQ19xNxIEm+egmvOX9q2aVZpccrfmQzQ34aYh8N/nRNmK7FFevxK8B1nw3T1BVp";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        lf  = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb  = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
        vt = hardwareMap.get(DcMotorEx.class, "vt");
        liftL = hardwareMap.get(DcMotorEx.class, "liftl");
        liftR = hardwareMap.get(DcMotorEx.class, "liftr");
        atmt = hardwareMap.get(Servo.class, "atmt");

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.FORWARD);
        vt.setDirection(DcMotor.Direction.FORWARD);
        liftL.setDirection(DcMotor.Direction.FORWARD);
        liftR.setDirection(DcMotor.Direction.REVERSE);

        initVuforia();

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        if (tfod != null) {
            tfod.activate();
        }

        waitForStart();
        runtime.reset();


        while (opModeIsActive() && (runtime.seconds() < 30.0)) {

            liftL.setPower(0);
            liftR.setPower(0);
            lf.setPower(0.5);
            rf.setPower(0.5);
            lb.setPower(0.5);
            rb.setPower(0.5);
            vt.setPower(0);
            sleep(1350);

            lf.setPower(0);
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);
            sleep(2000);

            if (checkBlock()) {

                lf.setPower(-0.3);
                rf.setPower(0.3);
                lb.setPower(0.3);
                rb.setPower(-0.3);
                sleep(300);
//
                lf.setPower(0.3);
                rf.setPower(0.3);
                lb.setPower(0.3);
                rb.setPower(0.3);
                sleep(500);
//
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                vt.setVelocity(1160);
                sleep(500);
//
                atmt.setPosition(1);
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                vt.setVelocity(1160);
                sleep(500);
//
                atmt.setPosition(1);
                lf.setPower(-0.5);
                rf.setPower(-0.5);
                lb.setPower(-0.5);
                rb.setPower(-0.5);
                vt.setVelocity(-1160 * 0.2);
                sleep(1300);
//
                lf.setPower(0.5);
                rf.setPower(-0.5);
                lb.setPower(-0.5);
                rb.setPower(0.5);
                sleep(4000);
//
                lf.setPower(0.5);
                rf.setPower(0.5);
                lb.setPower(0.5);
                rb.setPower(0.5);
                sleep(200);
//
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                vt.setVelocity(1160);
                sleep(300);
//
                lf.setPower(-0.5);
                rf.setPower(-0.5);
                lb.setPower(-0.5);
                rb.setPower(-0.5);
                sleep(1800);
//
                atmt.setPosition(0);
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                sleep(500);
//
                lf.setPower(-0.5);
                rf.setPower(0.5);
                lb.setPower(0.5);
                rb.setPower(-0.5);
                sleep(1500);
//
            } else {

                lf.setPower(0.5);
                rf.setPower(-0.5);
                lb.setPower(-0.5);
                rb.setPower(0.5);
                vt.setPower(0);
                sleep(675);

                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
                sleep(2000);

                if (checkBlock()) {

                    lf.setPower(-0.3);
                    rf.setPower(0.3);
                    lb.setPower(0.3);
                    rb.setPower(-0.3);
                    sleep(300);
//
                    lf.setPower(0.3);
                    rf.setPower(0.3);
                    lb.setPower(0.3);
                    rb.setPower(0.3);
                    sleep(500);
//
                    lf.setPower(0);
                    rf.setPower(0);
                    lb.setPower(0);
                    rb.setPower(0);
                    vt.setVelocity(1160);
                    sleep(500);
//
                    atmt.setPosition(1);
                    lf.setPower(0);
                    rf.setPower(0);
                    lb.setPower(0);
                    rb.setPower(0);
                    vt.setVelocity(1160);
                    sleep(500);
//
                    atmt.setPosition(1);
                    lf.setPower(-0.5);
                    rf.setPower(-0.5);
                    lb.setPower(-0.5);
                    rb.setPower(-0.5);
                    vt.setVelocity(-1160 * 0.2);
                    sleep(1300);
//
                    lf.setPower(0.5);
                    rf.setPower(-0.5);
                    lb.setPower(-0.5);
                    rb.setPower(0.5);
                    sleep(4000-675);
//
                    lf.setPower(0.5);
                    rf.setPower(0.5);
                    lb.setPower(0.5);
                    rb.setPower(0.5);
                    sleep(200);
//
                    lf.setPower(0);
                    rf.setPower(0);
                    lb.setPower(0);
                    rb.setPower(0);
                    vt.setVelocity(1160);
                    sleep(300);
//
                    lf.setPower(-0.5);
                    rf.setPower(-0.5);
                    lb.setPower(-0.5);
                    rb.setPower(-0.5);
                    sleep(1800);
//
                    atmt.setPosition(0);
                    lf.setPower(0);
                    rf.setPower(0);
                    lb.setPower(0);
                    rb.setPower(0);
                    sleep(500);
//
                    lf.setPower(-0.5);
                    rf.setPower(0.5);
                    lb.setPower(0.5);
                    rb.setPower(-0.5);
                    sleep(1500);
//
                } else {

                    lf.setPower(0.5);
                    rf.setPower(-0.5);
                    lb.setPower(-0.5);
                    rb.setPower(0.5);
                    vt.setPower(0);
                    sleep(675);

                    lf.setPower(0);
                    rf.setPower(0);
                    lb.setPower(0);
                    rb.setPower(0);
                    sleep(2000);

                    if (checkBlock()) {

                        lf.setPower(-0.3);
                        rf.setPower(0.3);
                        lb.setPower(0.3);
                        rb.setPower(-0.3);
                        sleep(300);
//
                        lf.setPower(0.3);
                        rf.setPower(0.3);
                        lb.setPower(0.3);
                        rb.setPower(0.3);
                        sleep(500);
//
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        vt.setVelocity(1160);
                        sleep(500);
//
                        atmt.setPosition(1);
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        vt.setVelocity(1160);
                        sleep(500);
//
                        atmt.setPosition(1);
                        lf.setPower(-0.5);
                        rf.setPower(-0.5);
                        lb.setPower(-0.5);
                        rb.setPower(-0.5);
                        vt.setVelocity(-1160 * 0.2);
                        sleep(1300);
//
                        lf.setPower(0.5);
                        rf.setPower(-0.5);
                        lb.setPower(-0.5);
                        rb.setPower(0.5);
                        sleep(4000-(675*2));
//
                        lf.setPower(0.5);
                        rf.setPower(0.5);
                        lb.setPower(0.5);
                        rb.setPower(0.5);
                        sleep(200);
//
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        vt.setVelocity(1160);
                        sleep(300);
//
                        lf.setPower(-0.5);
                        rf.setPower(-0.5);
                        lb.setPower(-0.5);
                        rb.setPower(-0.5);
                        sleep(1800);
//
                        atmt.setPosition(0);
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        sleep(500);
//
                        lf.setPower(-0.5);
                        rf.setPower(0.5);
                        lb.setPower(0.5);
                        rb.setPower(-0.5);
                        sleep(1500);
//
                    } else {

                        lf.setPower(-0.3);
                        rf.setPower(0.3);
                        lb.setPower(0.3);
                        rb.setPower(-0.3);
                        sleep(300);
//
                        lf.setPower(0.3);
                        rf.setPower(0.3);
                        lb.setPower(0.3);
                        rb.setPower(0.3);
                        sleep(500);
//
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        vt.setVelocity(1160);
                        sleep(500);
//
                        atmt.setPosition(1);
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        vt.setVelocity(1160);
                        sleep(500);
//
                        atmt.setPosition(1);
                        lf.setPower(-0.5);
                        rf.setPower(-0.5);
                        lb.setPower(-0.5);
                        rb.setPower(-0.5);
                        vt.setVelocity(-1160 * 0.2);
                        sleep(1300);
//
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        sleep(200);

                        lf.setPower(0.5);
                        rf.setPower(-0.5);
                        lb.setPower(-0.5);
                        rb.setPower(0.5);
                        sleep(4000-(675*2));
//
                        lf.setPower(0.5);
                        rf.setPower(0.5);
                        lb.setPower(0.5);
                        rb.setPower(0.5);
                        sleep(200);
//
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        vt.setVelocity(1160);
                        sleep(300);
//
                        lf.setPower(-0.5);
                        rf.setPower(-0.5);
                        lb.setPower(-0.5);
                        rb.setPower(-0.5);
                        sleep(1800);
//
                        atmt.setPosition(0);
                        lf.setPower(0);
                        rf.setPower(0);
                        lb.setPower(0);
                        rb.setPower(0);
                        sleep(500);
//
                        lf.setPower(-0.5);
                        rf.setPower(0.5);
                        lb.setPower(0.5);
                        rb.setPower(-0.5);
                        sleep(1500);
//
//max
                    }
                }
            }

        }
    }
    private void initVuforia() {

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minimumConfidence = 0.8;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
    private boolean checkBlock() {

        if (tfod != null) {
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel() == "Skystone") {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
