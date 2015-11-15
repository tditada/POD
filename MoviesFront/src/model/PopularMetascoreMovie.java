package model;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class PopularMetascoreMovie implements DataSerializable{
	
	private Double metaScore;
	private int year;
	private String titles;
	
	public PopularMetascoreMovie() {
		
	}
	
	public PopularMetascoreMovie(int year) {
		this.metaScore = 0.0;
		this.year = year;
		this.titles = "";
	}

	public String getTitles() {
		return titles;
	}

	public Double getMetaScore() {
		return metaScore;
	}

	public int getYear() {
		return year;
	}
	
	public void setMetaScore(Double metaScore) {
		this.metaScore = metaScore;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void resetTitles() {
		this.titles = "";
	}
	
	public void addTitle(String title) {
		titles += title;
		titles += " - ";
	}

	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.titles = in.readUTF();
		this.metaScore = in.readDouble();
		this.year = in.readInt();
	}

	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(titles);
		out.writeDouble(metaScore);
		out.writeInt(year);
	}
	
	@Override
	public String toString() {
		return "metascore: " + String.valueOf(metaScore) + " - " + titles;
	}

}
