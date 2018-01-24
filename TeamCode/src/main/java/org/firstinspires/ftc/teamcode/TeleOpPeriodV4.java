package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOpPeriodV4 ", group = "Linear Opmode")//
public class TeleOpPeriodV4 extends LinearOpMode {

    //om HardwareVar class te kunnen gebruiken (gebruik voor elke variabele r.)
    HardwareVar r = new HardwareVar();
    double degree;
    double drive;

    public void runOpMode(){
        //r. runt HardwareVar class
        r.init(hardwareMap);
        //reset de timer
        r.runtime.reset();
        //wacht tot play (niet init) ingedrukt wordt
        waitForStart();
 
        while(opModeIsActive()){
            drive    = Range.clip(gamepad1.right_trigger - gamepad1.left_trigger, -0.3, 0.3);

            if (drive > 0 && !gamepad1.dpad_right && !gamepad1.dpad_left) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            } else if (drive < 0) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            } else if (drive == 0 ) {
                r.LFpower = drive;
                r.LBpower = drive;
                r.RFpower = drive;
                r.RBpower = drive;
            }


            if (gamepad1.dpad_left && drive == 0) {
                r.LFpower = -0.8;
                r.LBpower = -0.8;
                r.RBpower =  0.8;
                r.RFpower =  0.8;
            }

            if (gamepad1.dpad_right && drive == 0) {
                r.LFpower =  0.8;
                r.LBpower =  0.8;
                r.RBpower =  -0.8;
                r.RFpower =  -0.8;
                ;
            }

            if (gamepad1.dpad_left && drive > 0) {
                r.LFpower = 0;
                r.LBpower = 0;
                r.RFpower = 1;
                r.RBpower = 1;
            }

            if (gamepad1.dpad_right && drive > 0) {
                r.LFpower = 1;
                r.LBpower = 1;
                r.RFpower = 0;
                r.RBpower = 0;
            }

            if (gamepad1.left_bumper) {
                r.LFpower = 1;
                r.LBpower =  -1;
                r.RFpower = -0.9;
                r.RBpower =  0.9;
            }

            if(gamepad1.right_bumper==true){
                r.LFpower =  -1;
                r.LBpower =   1;
                r.RFpower =  0.9;
                r.RBpower = -0.9;

            }



            r.LFmotor.setPower(r.LFpower);
            r.LBmotor.setPower(r.LBpower);
            r.RFmotor.setPower(r.RFpower);
            r.RBmotor.setPower(r.RBpower);

            // = Range.clip(gamepad1.right_stick_x, 0  , 1.0) ;

            if(gamepad1.a) {
                r.servo1.setPosition(0.4);
                telemetry.addData("Servo:", "0.4");
            }

            if(gamepad1.y) {
                r.servo1.setPosition(0);
                telemetry.addData("Servo:", "0");
            }

            if(gamepad1.b) {
                r.servo1.setPosition(1);
                telemetry.addData("Servo:", "1");
            }

            if(gamepad1.x) {
                r.servo1.setPosition(0.6);
                telemetry.addData("Servo:", "0.6");
            }


            telemetry.addData("rotation LFmotor", r.LFmotor.getPower());
            telemetry.addData("rotation LBmotor", r.LBmotor.getPower());
            telemetry.addData("rotation RFmotor", r.RFmotor.getPower());
            telemetry.addData("rotation RBmotor", r.RBmotor.getPower());
            telemetry.addData("Degree", degree);
            telemetry.addData("ServoPos", r.servo1.getPosition());
            telemetry.update();


        }
    }
}
