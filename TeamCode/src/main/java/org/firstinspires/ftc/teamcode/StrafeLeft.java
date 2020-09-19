package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Strafe To Left", group="Autonomous")
//@Disabled
public class StrafeLeft extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor lf = null;
    private DcMotor rf = null;
    private DcMotor lb = null;
    private DcMotor rb = null;
    private Servo atmt = null;
    private DcMotor liftL = null;
    private DcMotor liftR = null;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        lf  = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb  = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");
        atmt = hardwareMap.get(Servo.class, "atmt");
        liftL = hardwareMap.get(DcMotor.class, "liftl");
        liftR = hardwareMap.get(DcMotor.class, "liftr");

        lf.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.FORWARD);
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

            lf.setPower(-1.0);
            rf.setPower(1.0);
            lb.setPower(1.0);
            rb.setPower(-1.0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(1100);

            lf.setPower(0);
            rf.setPower(0);
            lb.setPower(0);
            rb.setPower(0);
            liftL.setPower(0);
            liftR.setPower(0);
            sleep(2000);
        }

    }
}
