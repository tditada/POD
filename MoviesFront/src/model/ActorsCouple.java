package model;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class ActorsCouple implements DataSerializable{

	private String coupleNames;
	private String movies;
	private int count;
	
	public ActorsCouple() {
		
	}
	
	public ActorsCouple(String names) {
		this.coupleNames = names;
		this.movies = "";
		this.count = 0;
	}
	
	public String getMovies() {
		return movies;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.coupleNames = in.readUTF();
		this.movies = in.readUTF();
	}
	
	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(coupleNames);
		out.writeUTF(movies);
	}
	
	public void addMovie(String movie) {
		this.movies += movie;
		this.movies += " - ";
		this.count++;
	}
	
	@Override
	public String toString() {
		return this.coupleNames + " : " + movies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coupleNames == null) ? 0 : coupleNames.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActorsCouple other = (ActorsCouple) obj;
		if (coupleNames == null) {
			if (other.coupleNames != null)
				return false;
		} else if (!coupleNames.equals(other.coupleNames))
			return false;
		return true;
	}
	
	

}
