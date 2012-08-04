package com.sharedissues.entities;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="activity")
public class Activity {
	@Id
	String activityId;
	
	String personEmail;
	
	String detail;
	
	String link;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date date = new Date();
	
	
	
	
	
}
