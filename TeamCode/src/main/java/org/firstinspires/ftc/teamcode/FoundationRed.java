package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="FoundationRed", group="Autonomous")
//@Disabled
public class FoundationRed extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lf;
    private DcMotor rf;
    private DcMotor lb;
    private DcMotor rb;
    private DcMotorEx vt;
    private Servo atmt;
    private DcMotor liftL;
    private DcMotor liftR;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        lf  = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb  = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
        vt = hardwareMap.get(DcMotorEx.class, "vt");
        atmt = hardwareMap.get(Servo.class, "atmt");
        liftL = hardwareMap.get(DcMotor.class, "liftl");
        liftR = hardwareMap.get(DcMotor.class, "liftr");

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.FORWARD);
        vt.setDirection(DcMotor.Direction.FORWARD);
        liftL.setDirection(DcMotor.Direction.REVERSE);
        liftR.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 30.0)) {

            lf.setPower(0);
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(20000);

            lf.setPower(1.0);
            rf.setPower(1.0);
            lb.setPower(1.0);
            rb.setPower(1.0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(1400);

            lf.setPower(-1.0);
            rf.setPower(1.0);
            lb.setPower(1.0);
            rb.setPower(-1.0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(800);

            lf.setPower(0);
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);
            vt.setPower(0.5);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(700);

            lf.setPower(-1.0);
            rf.setPower(-1.0);
            lb.setPower(-1.0);
            rb.setPower(-1.0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(1200);

            lf.setPower(1.0);
            rf.setPower(-1.0);
            lb.setPower(-1.0);
            rb.setPower(1.0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(1200);

        }

    }
}
