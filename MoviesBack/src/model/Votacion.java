package model;


import java.io.IOException;

import com.hazelcast.core.PartitionAware;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class Votacion implements DataSerializable 
{
	private String provincia;
	private String distrito;
	private String partido;
	private String formula;
	private int votos;
	

	// mantener el orden que se hizo en el write!
	public void readData(ObjectDataInput in) throws IOException 
	{
		 provincia = in.readUTF();
		 distrito = in.readUTF(); 
		 partido = in.readUTF();
		 formula = in.readUTF();
		 votos= in.readInt();
	}

	// mantener el orden que se hizo en el read!
	public void writeData(ObjectDataOutput out) throws IOException 
	{
		 out.writeUTF(provincia);
		 out.writeUTF(distrito);
		 out.writeUTF(partido);
		 out.writeUTF(formula);
		 out.writeInt(votos);
	}

    public String toString() 
    {
    	String auxi= String.format("Province %s, Distrito %s, Partido %s, Formula %s, Votos %d", 
    			provincia, distrito, partido, formula, votos);
    	return auxi;
    }

    // getter/setter para el Bean Pojo que usa la clase CsvBeanReader
    public void setProvincia(String aProvince) 
    {
        provincia= aProvince;
    }

    public String getProvincia() 
    {
        return provincia;
    }
    
    public void setDistrito(String aDistrito)
    {
        distrito= aDistrito;
    }

    public String getDistrito() 
    {
        return distrito;
    }
    
    public void setPartido(String aPartido)
    {
        partido= aPartido;
    }

    public String getPartido() 
    {
        return partido;
    }
    
    public void setFormula(String aFormula)
    {
        formula= aFormula;
    }

    public String getFormula() 
    {
        return formula;
    }
    
    public void setVotos(int aVotos)
    {
        votos= aVotos;
    }

    public int getVotos() 
    {
        return votos;
    }
}

