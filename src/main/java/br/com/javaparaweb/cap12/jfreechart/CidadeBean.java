package br.com.javaparaweb.cap12.jfreechart;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

import javax.faces.bean.*;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean ( name = "cidade" )
@RequestScoped
public class CidadeBean 
{
  private StreamedContent grafico;
  private static final Logger log = Logger.getLogger( CidadeBean.class.getName() );
  
  public CidadeBean() 
  {
	  try {
		  JFreeChart graficoPizza = ChartFactory.createPieChart("5 Cidades mais populosas de SC", this.geraDados(), true, true, false);
		  File arquivoGrafico = new File("pizza.png");
		  
		  ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoPizza, 500, 300);
		  this.grafico = new DefaultStreamedContent( new FileInputStream( arquivoGrafico ), "image/png" );
	  } catch( Exception e) {
		  log.severe(e.getMessage());
	  }
  }
  
  private DefaultPieDataset geraDados() 
  {
	  DefaultPieDataset dts = new DefaultPieDataset();
	  
	  dts.setValue("Blumenau", new Double(334002.0));
	  dts.setValue("Crici�ma", new Double(334002.0));
	  dts.setValue("Florianop�lis", new Double(334002.0));
	  dts.setValue("Joinville", new Double(334002.0));
	  dts.setValue("S�o Jos�", new Double(334002.0));
	  
	  return dts;
  }
  
  public StreamedContent getGrafico() {
	  return this.grafico;
  }
}
