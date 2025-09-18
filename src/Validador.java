public class Validador {

    public static boolean validarCPF(String cpf) {
        //Verifica se o CPF é nulo ou vazio
        if (cpf == null || cpf.trim().isEmpty()){
            System.out.println("Cpf nulo ou vazio! Informe um CPF válido!");
            return false;
        }

        //Remove carácteres . ou -
        String limpo = cpf.trim().replaceAll("[.-]", "");

        //Verifica se o CPF possue apenas números
        if (!limpo.matches("\\d{11}")) {
            System.out.println("O CPF informando deve apresentar apenas 11 números. Informe um CPF válido!");
            return false;
        }

        //Verifica se o CPF informado possue todos os números iguais
        if (limpo.chars().distinct().count() == 1) {
            System.out.println("CPF inválido, todos os números são iguais! Insira um CPF válido!");
            return false;
        }

        return checarDigitos(limpo);
    }

    private static boolean checarDigitos(String cpf) {
        int[] d = cpf.chars().map(c -> c - '0').toArray();

        // DV1
        int s1 = 0;

        for (int i = 0; i < 9; i++){
            s1 += d[i] * (10 - i);
        }

        int r1 = s1 % 11;
        int dv1 = (r1 < 2) ? 0 : 11 - r1;

        if (d[9] != dv1){
            return false;
        }

        // DV2
        int s2 = 0;

        for (int i = 0; i < 10; i++){
            s2 += d[i] * (11 - i);
        }

        int r2 = s2 % 11;
        int dv2 = (r2 < 2) ? 0 : 11 - r2;

        return d[10] == dv2;
    }

}

