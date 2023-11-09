package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
    TalonSRX armMotor = new TalonSRX(2);
    Solenoid ef = new Solenoid(1, PneumaticsModuleType.CTREPCM,0);
    public ArmSubsystem(){
        armMotor.configFactoryDefault();
        armMotor.configPeakCurrentLimit(15,1000);
        armMotor.configPeakCurrentDuration(50,1000);
        armMotor.configContinuousCurrentLimit(10,1000);

    }

    public void setPower(double power){
        power*=-0.6;
        if(power<-0.06)
            power-=0.3;
        armMotor.set(TalonSRXControlMode.PercentOutput,power);
    }

    public void toggleEF(){
        ef.toggle();
    }
}
