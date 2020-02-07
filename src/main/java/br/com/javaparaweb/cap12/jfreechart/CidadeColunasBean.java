package br.com.javaparaweb.cap12.jfreechart;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean (name="cidadeColunas")
@RequestScoped
public class CidadeColunasBean 
{
	private StreamedContent grafico;
	private static final Logger log = Logger.getLogger( CidadeColunasBean.class.getName() );
	
	public CidadeColunasBean() {
		  try {
			  JFreeChart graficoColunas = ChartFactory.createBarChart("5 Cidades mais populosas de SC", "Cidades", "Popula��o", this.geraDados(), PlotOrientation.VERTICAL, 
					                                          false, true, false);
			  File arquivoGrafico = new File("colunas.png");
			  
			  ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoColunas, 500, 300);
			  this.grafico = new DefaultStreamedContent( new FileInputStream( arquivoGrafico ), "image/png" );
		  } catch( Exception e) {
			  log.severe(e.getMessage());
		  }
	}
	
	
	  private DefaultCategoryDataset geraDados() 
	  {
		  DefaultCategoryDataset dts = new DefaultCategoryDataset();
		  
		  dts.setValue(new Double(334002.0), "Popula��o", "Blumenau");
		  dts.setValue(new Double(204667.0), "Popula��o","Crici�ma");
		  dts.setValue(new Double(461542.0), "Popula��o","Florianop�lis");
		  dts.setValue(new Double(55461.0), "Popula��o","Joinville");
		  dts.setValue(new Double(22856.0), "Popula��o","S�o Jos�");
		  
		  return dts;
	  }
	  
	  public StreamedContent getGrafico() {
		  return this.grafico;
	  }
	
	
}
