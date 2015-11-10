package model;

import java.io.IOException;
import java.util.List;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class ModelObject implements DataSerializable  {
	
	public static final String NOT_A_VALUE = "N/A";
	public static final Integer INVALID_YEAR = 0;
	public static final Double INVALID_METASCORE = -1.0;
	
	private String title;
	private Integer startYear;
	private Integer endYear;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private Double metascore;
	private Double imdbRating;
	private Long imdbVotes;
	private String imdbId;
	private String type;
	private Integer tomatoMeter;
	private Double tomatoRating;
	private Integer tomatoReviews;
	private Integer tomatoFresh;
	private Integer tomatoRotten;
	private String tomatoConsensus;
	private Integer tomatoUserMeter;
	private Double tomatoUserRating;
	private Integer tomatoUserReviews;
	private String dvd;
	private String boxOffice;
	private String production;
	private String website;
	private boolean response;
	
	
	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.title = in.readUTF();
		this.startYear = in.readInt();
		this.endYear = in.readInt();
		this.rated = in.readUTF();
		this.released = in.readUTF();
		this.runtime = in.readUTF();
		this.genre = in.readUTF();
		this.director = in.readUTF();
		this.writer = in.readUTF();
		this.actors = in.readUTF();
		this.plot = in.readUTF();
		this.language = in.readUTF();
		this.country = in.readUTF();
		this.awards = in.readUTF();
		this.poster = in.readUTF();
		this.metascore = in.readDouble();
		this.imdbRating = in.readDouble();
		this.imdbVotes = in.readLong();
		this.imdbId = in.readUTF();
		this.type = in.readUTF();
		this.tomatoMeter = in.readInt();
		this.tomatoRating = in.readDouble();
		this.tomatoReviews = in.readInt();
		this.tomatoFresh = in.readInt();
		this.tomatoRotten = in.readInt();
		this.tomatoConsensus = in.readUTF();
		this.tomatoUserMeter = in.readInt();
		this.tomatoUserRating = in.readDouble();
		this.tomatoUserReviews = in.readInt();
		this.dvd = in.readUTF();
		this.boxOffice = in.readUTF();
		this.production = in.readUTF();
		this.website = in.readUTF();
		this.response = in.readBoolean();
		
	}
	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
//		out.readUTF();
//		out.readInt();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readDouble();
//		out.readDouble();
//		out.readLong();
//		out.readUTF();
//		out.readUTF();
//		out.readInt();
//		out.readDouble();
//		out.readInt();
//		out.readInt();
//		out.readInt();
//		out.readUTF();
//		out.readInt();
//		out.readDouble();
//		out.readInt();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readBoolean();
		
	}
	public String getTitle() {
		return title;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public String getRated() {
		return rated;
	}
	public String getReleased() {
		return released;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getGenre() {
		return genre;
	}
	public String getDirector() {
		return director;
	}
	public String getWriter() {
		return writer;
	}
	public String getActors() {
		return actors;
	}
	public String getPlot() {
		return plot;
	}
	public String getLanguage() {
		return language;
	}
	public String getCountry() {
		return country;
	}
	public String getAwards() {
		return awards;
	}
	public String getPoster() {
		return poster;
	}
	public Double getMetascore() {
		return metascore;
	}
	public Double getImdbRating() {
		return imdbRating;
	}
	public Long getImdbVotes() {
		return imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public String getType() {
		return type;
	}
	public Integer getTomatoMeter() {
		return tomatoMeter;
	}
	public Double getTomatoRating() {
		return tomatoRating;
	}
	public Integer getTomatoReviews() {
		return tomatoReviews;
	}
	public Integer getTomatoFresh() {
		return tomatoFresh;
	}
	public Integer getTomatoRotten() {
		return tomatoRotten;
	}
	public String getTomatoConsensus() {
		return tomatoConsensus;
	}
	public Integer getTomatoUserMeter() {
		return tomatoUserMeter;
	}
	public Double getTomatoUserRating() {
		return tomatoUserRating;
	}
	public Integer getTomatoUserReviews() {
		return tomatoUserReviews;
	}
	public String getDvd() {
		return dvd;
	}
	public String getBoxOffice() {
		return boxOffice;
	}
	public String getProduction() {
		return production;
	}
	public String getWebsite() {
		return website;
	}
	public boolean isResponse() {
		return response;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStartYear(Integer year) {
		this.startYear = year;
	}
	public void setEndYear(Integer year) {
		this.endYear = year;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public void setMetascore(Double metascore) {
		this.metascore = metascore;
	}
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTomatoMeter(Integer tomatoMeter) {
		this.tomatoMeter = tomatoMeter;
	}
	public void setTomatoRating(Double tomatoRating) {
		this.tomatoRating = tomatoRating;
	}
	public void setTomatoReviews(Integer tomatoReviews) {
		this.tomatoReviews = tomatoReviews;
	}
	public void setTomatoFresh(Integer tomatoFresh) {
		this.tomatoFresh = tomatoFresh;
	}
	public void setTomatoRotten(Integer tomatoRotten) {
		this.tomatoRotten = tomatoRotten;
	}
	public void setTomatoConsensus(String tomatoConsensus) {
		this.tomatoConsensus = tomatoConsensus;
	}
	public void setTomatoUserMeter(Integer tomatoUserMeter) {
		this.tomatoUserMeter = tomatoUserMeter;
	}
	public void setTomatoUserRating(Double tomatoUserRating) {
		this.tomatoUserRating = tomatoUserRating;
	}
	public void setTomatoUserReviews(Integer tomatoUserReviews) {
		this.tomatoUserReviews = tomatoUserReviews;
	}
	public void setDvd(String dvd) {
		this.dvd = dvd;
	}
	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setResponse(boolean response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("TITLE: ")
			.append(title)
			.append('\n')
			.append("START YEAR: ")
			.append(startYear)
			.append('\n')
			.append("END YEAR: ")
			.append(endYear)
			.append('\n')
			.append("RATED: ")
			.append(rated)
			.append('\n')
			.append("RELEASED: ")
			.append(released)
			.append('\n')
			.append("RUNTIME: ")
			.append(runtime)
			.append('\n')
			.append("GENRES: ")
			.append(genre)
			.append('\n')
			.append("DIRECTOR: ")
			.append(director)
			.append('\n')
			.append("WRITER: ")
			.append(writer)
			.append('\n')
			.append("ACTORS: ")
			.append(actors)
			.append('\n')
			.append("PLOT: ")
			.append(plot)
			.append('\n')
			.append("LANGUAGE: ")
			.append(language)
			.append('\n')
			.append("COUNTRY: ")
			.append(country)
			.append('\n')
			.append("AWARDS: ")
			.append(awards)
			.append('\n')
			.append("POSTER: ")
			.append(poster)
			.append('\n')
			;
		return builder.toString();
				
	}
	
}
