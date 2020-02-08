/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private static DriveTrain m_instance;
  private Talon m_bL, m_fL, m_bR, m_fR;
  
  private SpeedController m_l, m_r;

  private DifferentialDrive m_drive;

  public static DriveTrain getInstance(){
		if(m_instance == null)
      m_instance = new DriveTrain();
		return m_instance;
	}
	
  public DriveTrain() {
    m_bL = new Talon(PortConstants.BACK_LEFT);
    m_bR = new Talon(PortConstants.BACK_RIGHT);
    m_fL = new Talon(PortConstants.FRONT_LEFT);
    m_fR = new Talon(PortConstants.FRONT_RIGHT);

    m_l = new SpeedControllerGroup(m_bL, m_fL);
    m_r = new SpeedControllerGroup(m_bR, m_fR);
  
    m_drive = new DifferentialDrive(m_l, m_r);
  
  }

  public void tankDrive(double x, double z, double correction){
    m_drive.tankDrive(-x+z, -x-z);
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
