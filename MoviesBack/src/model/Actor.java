package model;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;


public class Actor implements DataSerializable, Comparable<Actor> {
	
	private String name;
	private Long votes;
	
	public Actor() {
		
	}
	
	public Actor(String name, Long votes) {
		super();
		this.name = name;
		this.votes = votes;
	}
	
	public String getName() {
		return name;
	}

	public Long getVotes() {
		return votes;
	}

	public void addVotes(Long v) {
		this.votes += v;
	}
	
	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.name = in.readUTF();
		this.votes = in.readLong();
	}

	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(name);
		out.writeLong(votes);
	}

	@Override
	public int compareTo(Actor o) {
		if (this.votes.compareTo(o.getVotes()) == 0) {
			return o.getName().compareTo(this.getName());
		}
		return this.votes.compareTo(o.getVotes());
	}
	
	@Override
	public String toString() {
		return this.name.toString() + " " + String.valueOf(this.votes);
	}

}
