package br.upe.ecomp.model;
// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

public final class Game_Stub
    extends java.rmi.server.RemoteStub
    implements br.upe.ecomp.model.Game, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_getGameMode_0;
    private static java.lang.reflect.Method $method_getOpponent_1;
    private static java.lang.reflect.Method $method_getOpponentScenario_2;
    private static java.lang.reflect.Method $method_getPlayer_3;
    private static java.lang.reflect.Method $method_getPlayerScenario_4;
    private static java.lang.reflect.Method $method_setGameMode_5;
    private static java.lang.reflect.Method $method_setOpponent_6;
    private static java.lang.reflect.Method $method_setOpponentScenario_7;
    private static java.lang.reflect.Method $method_setPlayer_8;
    private static java.lang.reflect.Method $method_setPlayerScenario_9;
    
    static {
	try {
	    $method_getGameMode_0 = br.upe.ecomp.model.Game.class.getMethod("getGameMode", new java.lang.Class[] {});
	    $method_getOpponent_1 = br.upe.ecomp.model.Game.class.getMethod("getOpponent", new java.lang.Class[] {});
	    $method_getOpponentScenario_2 = br.upe.ecomp.model.Game.class.getMethod("getOpponentScenario", new java.lang.Class[] {});
	    $method_getPlayer_3 = br.upe.ecomp.model.Game.class.getMethod("getPlayer", new java.lang.Class[] {});
	    $method_getPlayerScenario_4 = br.upe.ecomp.model.Game.class.getMethod("getPlayerScenario", new java.lang.Class[] {});
	    $method_setGameMode_5 = br.upe.ecomp.model.Game.class.getMethod("setGameMode", new java.lang.Class[] {br.upe.ecomp.enumeration.GameMode.class});
	    $method_setOpponent_6 = br.upe.ecomp.model.Game.class.getMethod("setOpponent", new java.lang.Class[] {br.upe.ecomp.model.Player.class});
	    $method_setOpponentScenario_7 = br.upe.ecomp.model.Game.class.getMethod("setOpponentScenario", new java.lang.Class[] {br.upe.ecomp.model.Scenario.class});
	    $method_setPlayer_8 = br.upe.ecomp.model.Game.class.getMethod("setPlayer", new java.lang.Class[] {br.upe.ecomp.model.Player.class});
	    $method_setPlayerScenario_9 = br.upe.ecomp.model.Game.class.getMethod("setPlayerScenario", new java.lang.Class[] {br.upe.ecomp.model.Scenario.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public Game_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getGameMode()
    public br.upe.ecomp.enumeration.GameMode getGameMode()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getGameMode_0, null, -1510060612619410417L);
	    return ((br.upe.ecomp.enumeration.GameMode) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getOpponent()
    public br.upe.ecomp.model.Player getOpponent()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getOpponent_1, null, 409351992654904447L);
	    return ((br.upe.ecomp.model.Player) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getOpponentScenario()
    public br.upe.ecomp.model.Scenario getOpponentScenario()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getOpponentScenario_2, null, -2623694026249077903L);
	    return ((br.upe.ecomp.model.Scenario) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getPlayer()
    public br.upe.ecomp.model.Player getPlayer()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getPlayer_3, null, 4857469605964541230L);
	    return ((br.upe.ecomp.model.Player) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getPlayerScenario()
    public br.upe.ecomp.model.Scenario getPlayerScenario()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getPlayerScenario_4, null, -6049035492058444457L);
	    return ((br.upe.ecomp.model.Scenario) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setGameMode(GameMode)
    public void setGameMode(br.upe.ecomp.enumeration.GameMode $param_GameMode_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setGameMode_5, new java.lang.Object[] {$param_GameMode_1}, 3845064480970884822L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setOpponent(Player)
    public void setOpponent(br.upe.ecomp.model.Player $param_Player_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setOpponent_6, new java.lang.Object[] {$param_Player_1}, 6677135428063931576L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setOpponentScenario(Scenario)
    public void setOpponentScenario(br.upe.ecomp.model.Scenario $param_Scenario_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setOpponentScenario_7, new java.lang.Object[] {$param_Scenario_1}, -3564800712748656489L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setPlayer(Player)
    public void setPlayer(br.upe.ecomp.model.Player $param_Player_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setPlayer_8, new java.lang.Object[] {$param_Player_1}, 2473380589676756439L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setPlayerScenario(Scenario)
    public void setPlayerScenario(br.upe.ecomp.model.Scenario $param_Scenario_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setPlayerScenario_9, new java.lang.Object[] {$param_Scenario_1}, 4175614823938622507L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}