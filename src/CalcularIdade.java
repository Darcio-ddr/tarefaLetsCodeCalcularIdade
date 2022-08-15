import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalcularIdade {
	
	public static void formatarData(List<Pessoa> listaDePessoa)  {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", new Locale("pt", "BR"));
		
		for(int i = 0; i< listaDePessoa.size(); i++) {
			//String[] itemData = listaDePessoa.get(i).getDataNacimento().split("/");
			//LocalDate anoNascimento = LocalDate.of(Integer.parseInt(itemData[0]), Integer.parseInt(itemData[1]), Integer.parseInt(itemData[2])); 
			LocalDate anoNascimento = LocalDate.parse(listaDePessoa.get(i).getDataNacimento(), formatter);
			LocalDate dataAtual = LocalDate.now(); 
			Period diff = Period.between(anoNascimento, dataAtual); 
			 LocalDate localDate = LocalDate.of(diff.getYears(), diff.getMonths(), diff.getDays());
			DayOfWeek dayOfWeek = localDate.getDayOfWeek();
			 
			System.out.println(listaDePessoa.get(i).getNome() + " - "+ listaDePessoa.get(i).getDataNacimento() + " - "+dayOfWeek.toString()+" "+ diff.getYears()+" ano");
			 
			
		}
		
		

	}
	

	
	
	public static void main(String[] args) {
		List<Pessoa> listaDePessoa = new ArrayList<Pessoa>();
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Juliano");
		pessoa.setDataNacimento("1980/05/10");
		listaDePessoa.add(pessoa);
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Matheus");
		pessoa1.setDataNacimento("1991/02/17");
		listaDePessoa.add(pessoa1);
		
		formatarData(listaDePessoa);
		
	}
}
