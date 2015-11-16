package model;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class Movie implements DataSerializable{
	
	private String title;
	private Double metaScore;
	private int year;
	
	public Movie() {
		
	}
	
	public Movie(String title, Double metaScore, int year) {
		super();
		this.title = title;
		this.metaScore = metaScore;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public Double getMetaScore() {
		return metaScore;
	}

	public int getYear() {
		return year;
	}

	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.title = in.readUTF();
		this.metaScore = in.readDouble();
		this.year = in.readInt();
	}

	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(title);
		out.writeDouble(metaScore);
		out.writeInt(year);
	}
	
	

}
