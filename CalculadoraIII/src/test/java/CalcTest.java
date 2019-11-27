import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    @Test
    public void Suma_vacio_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "";
        String actual = sut.AddStrings(numberEnt);
        String expected = "";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Suma_un_numero_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "5.0";
        String actual = sut.AddStrings(numberEnt);
        String expected = "5.0";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Suma_dos_numeros_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "  5.0    3.1  ";
        String actual = sut.AddStrings(numberEnt);
        String expected = "8.1";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Suma_dos_numeros_sin_dec_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "   5    3  ";
        String actual = sut.AddStrings(numberEnt);
        String expected = "8";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Suma_dos_numeros_con_dec_mal_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "  5.0  1..11   3.0";
        String actual = sut.AddStrings(numberEnt);
        String expected = "8.0";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Suma_dos_numeros_con_Neg_mal_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "  5.0  -1-11   3.0";
        String actual = sut.AddStrings(numberEnt);
        String expected = "8.0";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Suma_dos_numeros_con_Neg_ok_calculadora () {
        Calc sut = new Calc();
        String numberEnt = "  5.0  -1.01   3.0";
        String actual = sut.AddStrings(numberEnt);
        String expected = "6.99";
        Assert.assertEquals(actual, expected);

    }


    @Test
    public void Suma_N_numeros_calculadora () {
        Calc suma = new Calc();
        String numberEnt = "  5.0    3.1  6.1  9.1  111.12  3000.10";
        String resultado1 = suma.AddStrings(numberEnt);
        String expected = "3134.52";
        Assert.assertEquals(resultado1, expected);

    }

    @Test
    public void Suma_N_numeros_separados_comas_calculadora () {
        Calc suma = new Calc();
        String numberEnt = "5.0,3.1,6.1,9.1,111.12,3000.10";
        String resultado1 = suma.AddStrings(numberEnt);
        String expected = "3134.52";
        Assert.assertEquals(resultado1, expected);

    }



}
