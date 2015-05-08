
class Imprime{
	
	Interpretador in;
	String nome;
	
	public Imprime(Interpretador i){
		this.in = i;
	}
		

	public void Imprimir(String[] linhas, int cont){
		// imprimindo Strings.
		if(linhas.length > 1 && linhas[1].contains("'") ){ 
			String s = " ";
			for(int i = 1; i < linhas.length; i++){
				s = s + linhas[i] + " ";
			}
			int a = s.trim().length();
			if(s.charAt(a) != '\''){ // teste se na ultima posicao tem aspas.
				System.out.println("Erro na impressao da String, Para impressao de String utiliza-se ' String ' ");
				System.exit(0);
			}
			String r = s.substring(2, (s.length() - 2)); // eliminando as ''
			System.out.println(r);
		}
		// impressao de variaveis	
		else if(linhas.length == 2){
			if(in.TestaString(linhas[1])) System.out.println(linhas[1]);
			else{
				Variaveis a = in.getVariavel(linhas[1]);
				if(a == null) in.erro.Erro5();
				System.out.println(a.getValor());
			}
				
		}
			//if(linhas[0].equals("string")){
			//	System.out.pirntln(linhas[1]);
			//}else if(linhas[0].equals("inteiro")){
			//	int a = Integer.parseInt(linhas[1]);
			//	System.out.println()
			//} 
			//double h = 0;
			//if(in.TestaString(linhas[1])){ // chama o TestaString para verificar se um numero.
			//	System.out.println(linhas[1]);
			//}else{
			//	if(in.VerificaVariavel(linhas[1]))   h = in.getValor(linhas[1]); // se não for um numero, chama o verificaVariavel que retornar o valor.
			//	else{
				//	System.out.println("problema na imopressao, variavel nao localizada"); System.exit(0);
				////}
			//	System.out.println(h);
			//}
		//}
		// impressão com operadores.
		else if(linhas.length > 3 && linhas.length < 5 && linhas[2].equals("+") || linhas[2].equals("-") || linhas[2].equals("*") || linhas[2].equals("/")){
			double num = 0, num1 = 0;
			if(in.TestaString(linhas[1])) num = Double.parseDouble(linhas[1]);  // testa se é um numero ou uma variavel, se nao for vai verificar nas variaveis se exite.	
			else{
				nome = linhas[1];
				Variaveis a = in.getVariavel(nome);
				if(a == null) in.erro.Erro5();
				if(a.getTipo().equals("string")) in.erro.Erro5();
				num = a.getValor();
			}
			if(in.TestaString(linhas[3])) num1 = Double.parseDouble(linhas[3]);	
			else{
				nome = linhas[3];
				Variaveis b = in.getVariavel(nome);
				if(b == null) in.erro.Erro10();
				if(b.getTipo().equals("string")) in.erro.Erro10();
				num1 = b.getValor();	
			}
			double res = in.op.operacoes(linhas[2], num, num1); // chama o metodo das operacoes para imprimir.
			System.out.println(res);
									
		}
					
	}
}
