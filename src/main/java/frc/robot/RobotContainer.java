
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.TeleDriveCom;
import frc.robot.subsystems.DriveTrainSub;

public class RobotContainer {

  private final DriveTrainSub m_DriveTrainSub;
  private Joystick m_Joystick;

  public RobotContainer() {
    m_DriveTrainSub = new DriveTrainSub();
    m_Joystick = new Joystick(Constants.JOYSTICK_CHANNEL);

    m_DriveTrainSub.setDefaultCommand(new TeleDriveCom(
        m_DriveTrainSub,
        () -> m_Joystick.getZ() * Constants.Z_SPEED_MULTIPLIER,
        () -> m_Joystick.getY() * Constants.Y_SPEED_MULTIPLIER));

    configureBindings();
  }

  private void configureBindings() {
  }
}
