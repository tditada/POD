package core;

import com.hazelcast.mapreduce.Reducer;    
import com.hazelcast.mapreduce.ReducerFactory;

import model.FormulaAvgTupla;
import model.FormulaTupla;


public class BasicReducer implements ReducerFactory<String, FormulaTupla, FormulaAvgTupla> 
{
	public Reducer<FormulaTupla, FormulaAvgTupla> newReducer(final String distrito) 
	{
		return new Reducer<FormulaTupla, FormulaAvgTupla>() {

			private FormulaTupla max;
			private int countVotos;

			public void beginReduce()  // una sola vez en cada instancia
			{
				//countVotos = 0;
				max= new FormulaTupla(-1, "");
			}

			public void reduce(FormulaTupla value) 
			{
				countVotos += value.getVotos();
				if (max.compareTo(value) < 1)
					max= value;
			}

			public FormulaAvgTupla finalizeReduce() 
			{
				double average = (double)(max.getVotos()) / countVotos;
				FormulaAvgTupla ans = new FormulaAvgTupla(average, max);
				System.out.println(String.format("FinalReduce for %s = %s", distrito, average));
				return ans ;
			}
		};
	}
}
