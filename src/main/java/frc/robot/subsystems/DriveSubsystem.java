package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    private TalonSRX frontRight = new TalonSRX(11);
    private TalonSRX frontLeft = new TalonSRX(12);
    private TalonSRX backRight = new TalonSRX(32);
    private TalonSRX backLeft = new TalonSRX(4);


    /** Creates a new driveTrain. */
    public DriveSubsystem() {

        // inverting motor outputs to prevent the robot from spinning in place
        frontLeft.setInverted(InvertType.InvertMotorOutput);
        backLeft.setInverted(InvertType.InvertMotorOutput);

        //backLeft TalonSRX follow the outputs given to frontLeft TalonSRX
        backLeft.follow(frontLeft);

        //backRight TalonSRX follows the outputs given to frontRight TalonSRX
        backRight.follow(frontRight);


    }
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
    // creates a method named m_drive, intaking two double variables
    public void drive( double drive, double turn){

        //setting voltage output to the motor controllers in terms of percent output ( 1 = 100%, .5 = 50%)
        frontRight.set(ControlMode.PercentOutput, (drive + turn) * .3);
        frontLeft.set(ControlMode.PercentOutput, (drive - turn) * .3);

    }

}
