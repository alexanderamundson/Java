package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PersistanceManagerTest {
static int index = 0;
	
	static SiteManager sm = new SiteManager();
	static LocalDateTime dateCreated = LocalDateTime.now();
	PersistanceManager pm = new PersistanceManager();
	File file = new File("SiteManger_File");
	
	@BeforeAll
	static void startText(){
		while(index < 100) {
			sm.addMember("Member-" + index, "lastname", ""+index, index + "@gmail.com", dateCreated);
			if(index % 10 == 0) {
				sm.addGroup("Group-" + index/10, index/10+" is great", dateCreated);
			}
			index++;
		}
		Question q = new Question("Title", "Text", dateCreated);
		Answer a = new Answer(q,"Text",dateCreated);
		for(Member m : sm.getMembers("-5")) {
			m.joinGroup(sm.getGroup("Group-5"), dateCreated);
			m.addAnswer(sm.getGroup("Group-5"), q, a, dateCreated);
		}
		for(Member m : sm.getMembers("1")) {
			m.joinGroup(sm.getGroup("Group-1"), dateCreated);
			m.addAnswer(sm.getGroup("Group-1"), q, a, dateCreated);
		}
		for(Member m : sm.getMembers("2@gmail")) {
			m.joinGroup(sm.getGroup("Group-2"), dateCreated);
			m.addAnswer(sm.getGroup("Group-2"), q, a, dateCreated);
		}
		
	}
	

	@Test
	void testPersistanceManager() {
		assertTrue(pm != null);
	}

	@Test
	void testSave() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			pm.save(sm, fos);
		} catch(Exception e) {
			System.out.println("ERROR: "+ e);
		}
		
		assertTrue(file.exists());
		
		
	}

	@Test
	void testRead() {
		try {
			FileInputStream fis = new FileInputStream(file);
			SiteManager sm2 = pm.read(fis);
			for(Group g : sm2.getGroups()) {
				for(Member m: g.getMembers()) {
					System.out.println(g.getTitle() + ": " + m.getFirstName());
				}
			}
		} catch(Exception e) {
			System.out.print(e);
		}
		
		
	}

}
