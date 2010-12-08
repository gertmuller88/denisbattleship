package br.upe.ecomp.model;

import java.lang.reflect.Method;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteStub;
import br.upe.ecomp.enumeration.GameMode;

public final class Game_Stub extends RemoteStub implements Game, Remote
{
    private static final long serialVersionUID = 2;
    private static Method $method_getGameMode_0;
    private static Method $method_getOpponent_1;
    private static Method $method_getOpponentScenario_2;
    private static Method $method_getPlayer_3;
    private static Method $method_getPlayerScenario_4;
    private static Method $method_setGameMode_5;
    private static Method $method_setOpponent_6;
    private static Method $method_setOpponentScenario_7;
    private static Method $method_setPlayer_8;
    private static Method $method_setPlayerScenario_9;
    
    static
    {
    	try
    	{
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
    	}
    	catch(NoSuchMethodException e)
    	{ throw new NoSuchMethodError("stub class initialization failed"); }
    }
    
    public Game_Stub(RemoteRef ref)
    { super(ref); }
    
    public GameMode getGameMode() throws RemoteException
    {
    	try
    	{
    		Object $result = ref.invoke(this, $method_getGameMode_0, null, -1510060612619410417L);
    		return ((br.upe.ecomp.enumeration.GameMode) $result);
    	}
    	catch(RuntimeException e)
    	{ throw e; }
    	catch(RemoteException e)
    	{ throw e; }
    	catch(Exception e)
    	{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public Player getOpponent() throws RemoteException
    {
		try
		{
			Object $result = ref.invoke(this, $method_getOpponent_1, null, 409351992654904447L);
			return ((br.upe.ecomp.model.Player) $result);
		}
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public Scenario getOpponentScenario() throws RemoteException
    {
		try
		{
		    Object $result = ref.invoke(this, $method_getOpponentScenario_2, null, -2623694026249077903L);
		    return ((br.upe.ecomp.model.Scenario) $result);
		}
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public Player getPlayer() throws RemoteException
    {
		try
		{
		    Object $result = ref.invoke(this, $method_getPlayer_3, null, 4857469605964541230L);
		    return ((br.upe.ecomp.model.Player) $result);
		}
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public Scenario getPlayerScenario() throws RemoteException
    {
		try
		{
		    Object $result = ref.invoke(this, $method_getPlayerScenario_4, null, -6049035492058444457L);
		    return ((br.upe.ecomp.model.Scenario) $result);
		}
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public void setGameMode(GameMode $param_GameMode_1) throws RemoteException
    {
		try
		{ ref.invoke(this, $method_setGameMode_5, new java.lang.Object[] {$param_GameMode_1}, 3845064480970884822L); }
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public void setOpponent(Player $param_Player_1) throws RemoteException
    {
		try
		{ ref.invoke(this, $method_setOpponent_6, new java.lang.Object[] {$param_Player_1}, 6677135428063931576L); }
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public void setOpponentScenario(Scenario $param_Scenario_1) throws RemoteException
    {
		try
		{ ref.invoke(this, $method_setOpponentScenario_7, new java.lang.Object[] {$param_Scenario_1}, -3564800712748656489L); }
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public void setPlayer(Player $param_Player_1) throws RemoteException
    {
		try
		{ ref.invoke(this, $method_setPlayer_8, new java.lang.Object[] {$param_Player_1}, 2473380589676756439L); }
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }
    
    public void setPlayerScenario(Scenario $param_Scenario_1) throws RemoteException
    {
		try
		{ ref.invoke(this, $method_setPlayerScenario_9, new java.lang.Object[] {$param_Scenario_1}, 4175614823938622507L); }
		catch(RuntimeException e)
		{ throw e; }
		catch(RemoteException e)
		{ throw e; }
		catch(Exception e)
		{ throw new java.rmi.UnexpectedException("undeclared checked exception", e); }
    }

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}
}
