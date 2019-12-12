import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KlubbLagTest {


    @Test
    void addNewLagTest() {
        KlubbInfo klubbInfo = new KlubbInfo("Acmilan", "milan", "123", "milan@");
        KlubbLag klubbLag = new KlubbLag();

        klubbLag.addNewLag(klubbInfo);

        assertEquals(0, klubbLag.findLag("Acmilan"));

    }

    @Test
    void addNewLagTestStub() {
       // KlubbInfo klubbInfo = new KlubbInfo("Acmilan", "milan", "123", "milan@");
        KlubbInfoStub klubbInfoStub = new KlubbInfoStub();
        KlubbLag klubbLag = new KlubbLag();

        klubbLag.addNewLag(klubbInfoStub);

        assertEquals("Barcelona", klubbInfoStub.getNamn());

    }



    @Test
    void findLagTest() {

        //KlubbInfo klubbInfo = new KlubbInfo("Barcelona","barca","321","barca@");
        KlubbInfo klubbInfo = new KlubbInfoStub();

        KlubbLag klubbLag = new KlubbLag();

        klubbLag.addNewLag(klubbInfo);


        assertEquals(0, klubbLag.findLag("Barcelona"));
    }

    @Test
    void removeLagTest() {
        KlubbInfo klubbInfo = new KlubbInfo("Paris", "psg", "456", "psg@");
        KlubbLag klubbLag = new KlubbLag();

        klubbLag.addNewLag(klubbInfo);

        klubbLag.findLag("Paris");
        boolean laget = klubbLag.removeLag(klubbInfo);


        assertFalse(laget);
    }

    @Test
    void removeLagTestTrue() {
        KlubbInfo klubbInfo = new KlubbInfo("Paris", "psg", "456", "psg@");
        KlubbLag klubbLag = new KlubbLag();

        klubbLag.addNewLag(klubbInfo);

        klubbLag.findLag("Paris");
        boolean laget = klubbLag.removeLag(klubbInfo);


        assertTrue(laget);
    }

    @Test
    void updateLagTest() {
       // KlubbInfo klubbInfo = new KlubbInfo("Paris", "psg", "456", "psg@");
        KlubbLag klubbLag = new KlubbLag();
        KlubbInfo oldKlubbinfo = new KlubbInfo("kkk", "hhh", "33333", "fghjk");
        klubbLag.addNewLag(oldKlubbinfo);
        KlubbInfo newKlubbInfo = new KlubbInfo("jdkwaj", "dkf", "809", "kamsd");

        klubbLag.findLag("Paris");
        boolean laget = klubbLag.updateLag(oldKlubbinfo, newKlubbInfo);


        assertTrue(laget);

    }
}
