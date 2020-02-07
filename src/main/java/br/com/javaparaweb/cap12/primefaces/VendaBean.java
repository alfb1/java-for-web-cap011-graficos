package br.com.javaparaweb.cap12.primefaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean (name="venda")
@RequestScoped
public class VendaBean 
{
   private PieChartModel vendaPais;
   
   public VendaBean() {
	   this.vendaPais = new PieChartModel();
	   
	   this.vendaPais.set("Brasil", 540.50f);
	   this.vendaPais.set("Estados Unidos", 590.52f);
	   this.vendaPais.set("Inglaterra", 475.30f);
	   this.vendaPais.set("França", 400);
	   this.vendaPais.set("Alemanha", 393.33f);
	   
	   this.vendaPais.setTitle("Gráfico de vendas por país.");
	   this.vendaPais.setLegendPosition("e");
	   this.vendaPais.setShowDataLabels(true);
	   this.vendaPais.setDataFormat("percent");
   }
   
   public PieChartModel getVendaPais() {
	   return this.vendaPais;
   }
   
}
