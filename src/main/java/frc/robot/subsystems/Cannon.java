/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class Cannon extends SubsystemBase {
  /**
   * Creates a new Air.
   */
	private Solenoid m_gate;
	private Talon m_wM;

	static Cannon instance;
	
	public static Cannon getInstance(){
		if(instance == null){
			instance = new Cannon();
		}
		return instance;
	}
	
	private Cannon(){
		m_gate = new Solenoid(PortConstants.GATE_SOLENOID);
		m_wM = new Talon(PortConstants.WINDOW_MOTOR);
	}
	
	public void setGate(boolean mode){
		m_gate.set(mode);
	}

	public void moveAngle(double amount){
		m_wM.set(amount);
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
