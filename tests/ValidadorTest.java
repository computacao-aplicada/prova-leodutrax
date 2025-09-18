import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidadorTest {
    @Test
    void deveValidarCPFValido() {
        //CPF com mascára
        assertTrue(Validador.validarCPF("529.982.247-25"));
        //CPF sem máscara
        assertTrue(Validador.validarCPF("52998224725"));
    }

    @Test
    void deveRejeitarEntradasInvalidas() {
        //CPF nulo
        assertFalse(Validador.validarCPF(null));
        //CPF vazio
        assertFalse(Validador.validarCPF(""));
        //CPF com letra
        assertFalse(Validador.validarCPF("529.982.247-2X"));
        //CPF com todos os números iguais
        assertFalse(Validador.validarCPF("00000000000"));
    }

    @Test
    void deveRejeitarTamanhosIncorretos() {
        //10 dígitos
        assertFalse(Validador.validarCPF("935.411.347-8"));
        //12 dígitos
        assertFalse(Validador.validarCPF("935.411.347-800")); // 12 dígitos
    }
}
