package model;

import java.io.IOException;


import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class FormulaAvgTupla implements DataSerializable{

	private double average;
	private FormulaTupla tupla;

	public FormulaAvgTupla() {

	}

	public FormulaAvgTupla(double average, FormulaTupla tupla) {
		this.average = average;
		this.tupla = tupla;
	}

	public double getAverage() {
		return average;
	}

	public FormulaTupla getTupla() {
		return tupla;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public void setTupla(FormulaTupla tupla) {
		this.tupla = tupla;
	}

	public void writeData(ObjectDataOutput out)
			throws IOException {

		out.writeDouble(average);
		out.writeObject(tupla);
	}

	public void readData(ObjectDataInput in)
			throws IOException {

		average= in.readDouble();
		tupla = in.readObject();
	}

	public String toString() {

		return String.format("Formula: %s con %f votos", tupla.getFormula(), average);
	}



}
