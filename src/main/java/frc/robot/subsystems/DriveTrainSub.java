
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSub extends SubsystemBase {
  private CANSparkMax fLMotor;
  private CANSparkMax rLMotor;
  private CANSparkMax fRMotor;
  private CANSparkMax rRMotor;

  private DifferentialDrive driveTrain;

  public DriveTrainSub() {
    fLMotor = new CANSparkMax(Constants.FL_MOTOR_CHANNEL, MotorType.kBrushless);
    rLMotor = new CANSparkMax(Constants.RL_MOTOR_CHANNEL, MotorType.kBrushless);
    fRMotor = new CANSparkMax(Constants.FR_MOTOR_CHANNEL, MotorType.kBrushless);
    rRMotor = new CANSparkMax(Constants.RR_MOTOR_CHANNEL, MotorType.kBrushless);

    fLMotor.restoreFactoryDefaults();
    fRMotor.restoreFactoryDefaults();
    rLMotor.restoreFactoryDefaults();
    rRMotor.restoreFactoryDefaults();

    rLMotor.follow(fLMotor);
    rRMotor.follow(fRMotor);

    driveTrain = new DifferentialDrive(fLMotor, fRMotor);
  }

  public void arcadeDrive(double xSpeed, double ySpeed) {
    driveTrain.arcadeDrive(xSpeed, ySpeed);
  }

  public void arcadeDriveStop() {
    driveTrain.arcadeDrive(Constants.STOP_SPEED, Constants.STOP_SPEED);
  }
}
