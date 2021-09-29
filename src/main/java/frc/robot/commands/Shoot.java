/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cannon;

public class Shoot extends CommandBase {
  /**
   * Creates a new Shoot.
   */
  private Cannon m_cannon;
  private Timer m_timer;
  private double m_duration;

  public Shoot(Cannon cannon, double duration) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_cannon = cannon;
    m_timer = new Timer();
    m_duration = duration;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
    m_cannon.setGate(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_timer.stop();
    m_cannon.setGate(false);
    m_timer.reset() 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_timer.get() >= m_duration;
  }
}
