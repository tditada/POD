package model;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class ActorCount implements DataSerializable {

	private String names;
	private Integer count;
	
	public ActorCount() {
	
	}
	
	public ActorCount(String names, Integer count) {
		this.names = names;
		this.count = count;
	}
	
	public String getName() {
		return names;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void addActor(String n) {
		this.names += " - ";
		this.names += n;
	}
	
	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.names = in.readUTF();
		this.count = in.readInt();
	}
	
	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(names);
		out.writeInt(count);
	}

	@Override
	public String toString() {
		return names + " - count: " + count;
	}
	
}
