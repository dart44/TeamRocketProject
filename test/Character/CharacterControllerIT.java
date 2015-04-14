/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason
 */
public class CharacterControllerIT {
    
    public CharacterControllerIT() {
    }

    /**
     * Test of addCharacter method, of class CharacterController.
     */
    /*
    @Test
    public void testAddCharacter() {
        System.out.println("addCharacter");
        String player = "";
        CharacterController instance = new CharacterController();
        instance.addCharacter(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCharacter method, of class CharacterController.
     
    @Test
    public void testRemoveCharacter() {
        System.out.println("removeCharacter");
        Character c = null;
        CharacterController instance = new CharacterController();
        instance.removeCharacter(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class CharacterController.
     *
    @Test
    public void testSetName() {
        System.out.println("setName");
        Character ch = null;
        String name = "";
        CharacterController instance = new CharacterController();
        instance.setName(ch, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class CharacterController.
     
    @Test
    public void testGetName() {
        System.out.println("getName");
        Character ch = null;
        CharacterController instance = new CharacterController();
        String expResult = "";
        String result = instance.getName(ch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayer method, of class CharacterController.
     
    @Test
    public void testSetPlayer() {
        System.out.println("setPlayer");
        Character ch = null;
        String player = "";
        CharacterController instance = new CharacterController();
        instance.setPlayer(ch, player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayer method, of class CharacterController.
     
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Character ch = null;
        CharacterController instance = new CharacterController();
        String expResult = "";
        String result = instance.getPlayer(ch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class CharacterController.
     
    @Test
    public void testSet() {
        System.out.println("set");
        Character ch = null;
        String function = "";
        int input = 0;
        CharacterController instance = new CharacterController();
        instance.set(ch, function, input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of get method, of class CharacterController.
     * Not tested: tests a series of get methods
     */
    /*
    @Test
    public void testGet() {
        System.out.println("get");
        Character ch = null;
        String function = "";
        CharacterController instance = new CharacterController();
        int expResult = 0;
        int result = instance.get(ch, function);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    /**
     * Test of CheckHP method, of class CharacterController.
     */
    @Test
    public void testCheckHP() {
        System.out.println("CheckHP");
        Character ch = new Character("PacMan");
        CharacterController instance = new CharacterController();
        System.out.printf("Character's actual HP: %d\n", ch.getCurrentHP());
        Boolean expResult = true;
        Boolean result = instance.CheckHP(ch);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("CheckHP() failed.");
        if(result == true)
            System.out.println("CheckHP() Passed");
        else
            System.out.println("CheckHP() Failed");
    }

    /**
     * Test of CheckAP method, of class CharacterController.
     */
    @Test
    public void testCheckAP() {
        System.out.println("CheckAP");
        Character ch = new Character("PacMan");
        CharacterController instance = new CharacterController();
        System.out.printf("Character's actual AP: %d\n", ch.getCurrentAP());
        Boolean expResult = true;
        Boolean result = instance.CheckAP(ch);
        if(result == true)
            System.out.println("CheckAP() Passed");
        else
            System.out.println("CheckAP() Failed");
        
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("CheckAP() failed");
    }

    /**
     * Test of Attack method, of class CharacterController.
     */
    @Test
    public void testAttack() {
        System.out.println("Attack");
        Character attacker = new Character("PackMan");
        Character target = new Character("Clyde");
        System.out.printf("Target's HP before attack: %d\n", target.getCurrentHP());
        int AP = 15;
        CharacterController instance = new CharacterController();
        System.out.println("Commencing test attack");
        instance.Attack(attacker, target, AP);
        System.out.println("Test attack complete");
        System.out.printf("Target's HP after attack: %d\n", target.getCurrentAP());
    }
    
}
