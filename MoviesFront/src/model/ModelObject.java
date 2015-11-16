package model;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class ModelObject implements DataSerializable  {
	
	public static final String TYPE_MOVIE = "movie";
	public static final String TYPE_SERIE = "series";
	public static final String NOT_A_VALUE = "N/A";
	public static final Integer INVALID_YEAR = 0;
	public static final Double INVALID_METASCORE = 0.0;
	public static final Double INVALID_IMDB_RATING = 0.0;
	public static final Long INVALID_IMDB_VOTES = 0L;
	public static final Integer INVALID_TOMATO_METER = 0;
	
	private String title;
	private Integer year;
	private Integer startYear;
	private Integer endYear;
	private String director;
	private String actors;
	private Double metascore;
	private Long imdbVotes;
	private String type;
	
	public ModelObject() {

	}
	
	public ModelObject(String title,
					Integer year,
					Integer startYear,
					Integer endYear,
					String director,
					String actors,
					Double metascore,
					Long imdbVotes,
					String type) {
		this.title = title;
		this.year = year;
		this.startYear = startYear;
		this.endYear = endYear;
		this.director = director;
		this.actors = actors;
		this.metascore = metascore;
		this.imdbVotes = imdbVotes;
		this.type = type;
	}
	
	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.title = in.readUTF();
		this.year = in.readInt();
		this.startYear = in.readInt();
		this.endYear = in.readInt();
		this.director = in.readUTF();
		this.actors = in.readUTF();
		this.metascore = in.readDouble();
		this.imdbVotes = in.readLong();
		this.type = in.readUTF();
		
	}
	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(title);
		out.writeInt(year);
		out.writeInt(startYear);
		out.writeInt(endYear);
		out.writeUTF(director);
		out.writeUTF(actors);
		out.writeDouble(metascore);
		out.writeLong(imdbVotes);
		out.writeUTF(type);
	}

	public String getTitle() {
		return title;
	}
	public Integer getYear() {
		return year;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public String getDirector() {
		return director;
	}
	public String getActors() {
		return actors;
	}
	public Double getMetascore() {
		return metascore;
	}
	public Long getImdbVotes() {
		return imdbVotes;
	}
	public String getType() {
		return type;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void setStartYear(Integer year) {
		this.startYear = year;
	}
	public void setEndYear(Integer year) {
		this.endYear = year;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public void setMetascore(Double metascore) {
		this.metascore = metascore;
	}
	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("TITLE: ")
			.append(title)
			.append('\n')
			.append("YEAR: ")
			.append(year)
			.append('\n')
			.append("START YEAR: ")
			.append(startYear)
			.append('\n')
			.append("END YEAR: ")
			.append(endYear)
			.append('\n')
			.append("DIRECTOR: ")
			.append(director)
			.append('\n')
			.append("ACTORS: ")
			.append(actors)
			.append('\n')
			.append("METASCORE: ")
			.append(metascore)
			.append('\n')
			.append("IMDB VOTES: ")
			.append(imdbVotes)
			.append('\n')
			.append("TYPE: ")
			.append(type)
			.append('\n')
			;
		return builder.toString();
				
	}
	
	public List<String> getActorsList() {
		List<String> list = Arrays.asList(this.actors.split("\\s*,\\s*"));
		return list;
	}
	
}
