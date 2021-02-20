 

//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.smi.*;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.*;
import org.snmp4j.agent.mo.snmp.smi.*;
import org.snmp4j.agent.request.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.mo.snmp.tc.*;



//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class GrEventosMib 
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
implements MOGroup 
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
{

  private static final LogAdapter LOGGER = 
      LogFactory.getLogger(GrEventosMib.class);

//--AgentGen BEGIN=_STATIC
//--AgentGen END

  // Factory
  private MOFactory moFactory = 
    DefaultMOFactory.getInstance();

  // Constants 

  /**
   * OID of this MIB module for usage which can be 
   * used for its identification.
   */
  public static final OID oidGrEventosMib =
    new OID(new int[] { 1,3,6,1,4,1,8888 });

  // Identities
  // Scalars
  public static final OID oidNumeroEventos = 
    new OID(new int[] { 1,3,6,1,4,1,8888,1,0 });
  // Tables

  // Notifications

  // Enumerations




  // TextualConventions

  // Scalars
  private MOScalar<Integer32> numeroEventos;

  // Tables
  public static final OID oidEventoEntry = 
    new OID(new int[] { 1,3,6,1,4,1,8888,2,1 });

  // Index OID definitions
  public static final OID oidEventoIndex =
    new OID(new int[] { 1,3,6,1,4,1,8888,2,1,1 });

  // Column TC definitions for eventoEntry:
    
    // Column sub-identifier definitions for eventoEntry:
    public static final int colEventoIndex = 1;
    public static final int colEventoName = 2;
    public static final int colEventoEstado = 3;
    public static final int colEventoTempo = 4;
    public static final int colEventoDuracao = 5;
    public static final int colEventoFrasePassado = 6;
    public static final int colEventoFrasePresente = 7;
    public static final int colEventoFraseFuturo = 8;

    // Column index definitions for eventoEntry:
    public static final int idxEventoIndex = 0;
    public static final int idxEventoName = 1;
    public static final int idxEventoEstado = 2;
    public static final int idxEventoTempo = 3;
    public static final int idxEventoDuracao = 4;
    public static final int idxEventoFrasePassado = 5;
    public static final int idxEventoFrasePresente = 6;
    public static final int idxEventoFraseFuturo = 7;

  private MOTableSubIndex[] eventoEntryIndexes;
  private MOTableIndex eventoEntryIndex;

    @SuppressWarnings(value={"rawtypes"})
    private MOTable<EventoEntryRow, MOColumn,
        MOTableModel<EventoEntryRow>> eventoEntry;
    private MOTableModel<EventoEntryRow> eventoEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

  /**
   * Constructs a GrEventosMib instance without actually creating its
   * <code>ManagedObject</code> instances. This has to be done in a
   * sub-class constructor or after construction by calling 
   * {@link #createMO(MOFactory moFactory)}. 
   */
  protected GrEventosMib() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
  }

  /**
   * Constructs a GrEventosMib instance and actually creates its
   * <code>ManagedObject</code> instances using the supplied 
   * <code>MOFactory</code> (by calling
   * {@link #createMO(MOFactory moFactory)}).
   * @param moFactory
   *    the <code>MOFactory</code> to be used to create the
   *    managed objects for this module.
   */
  public GrEventosMib(MOFactory moFactory) {
  	this();
    //--AgentGen BEGIN=_FACTORYCONSTRUCTOR::factoryWrapper
    //--AgentGen END
  	this.moFactory = moFactory;
    createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
//--AgentGen END
  }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

  /**
   * Create the ManagedObjects defined for this MIB module
   * using the specified {@link MOFactory}.
   * @param moFactory
   *    the <code>MOFactory</code> instance to use for object 
   *    creation.
   */
  protected void createMO(MOFactory moFactory) {
    addTCsToFactory(moFactory);
    numeroEventos = 
      moFactory.createScalar(oidNumeroEventos,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Integer32());
    createEventoEntry(moFactory);
  }

  public MOScalar<Integer32> getNumeroEventos() {
    return numeroEventos;
  }


    @SuppressWarnings(value={"rawtypes"})
    public MOTable<EventoEntryRow,MOColumn,MOTableModel<EventoEntryRow>> getEventoEntry() {
        return eventoEntry;
    }


    @SuppressWarnings(value={"unchecked"})
    private void createEventoEntry(MOFactory moFactory) {
        // Index definition
    eventoEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidEventoIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)
    };

    eventoEntryIndex = 
      moFactory.createIndex(eventoEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
    //--AgentGen BEGIN=eventoEntry::isValidIndex
    //--AgentGen END
        return isValidIndex;
      }
    });

        // Columns
        MOColumn<?>[] eventoEntryColumns = new MOColumn<?>[8];
        eventoEntryColumns[idxEventoIndex] =
        moFactory.createColumn(colEventoIndex,
                               SMIConstants.SYNTAX_COUNTER32,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoName] =
        moFactory.createColumn(colEventoName,
                               SMIConstants.SYNTAX_OCTET_STRING,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoEstado] =
        moFactory.createColumn(colEventoEstado,
                               SMIConstants.SYNTAX_INTEGER,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempo] =
        moFactory.createColumn(colEventoTempo,
                               SMIConstants.SYNTAX_TIMETICKS,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoDuracao] =
        moFactory.createColumn(colEventoDuracao,
                               SMIConstants.SYNTAX_TIMETICKS,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoFrasePassado] =
        moFactory.createColumn(colEventoFrasePassado,
                               SMIConstants.SYNTAX_OCTET_STRING,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoFrasePresente] =
        moFactory.createColumn(colEventoFrasePresente,
                               SMIConstants.SYNTAX_OCTET_STRING,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoFraseFuturo] =
        moFactory.createColumn(colEventoFraseFuturo,
                               SMIConstants.SYNTAX_INTEGER,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        // Table model
        eventoEntryModel =
            moFactory.createTableModel(oidEventoEntry,
                                       eventoEntryIndex,
                                       eventoEntryColumns);
        ((MOMutableTableModel<EventoEntryRow>)eventoEntryModel).setRowFactory(
            new EventoEntryRowFactory());
        eventoEntry =
            moFactory.createTable(oidEventoEntry,
                                  eventoEntryIndex,
                                  eventoEntryColumns,
                                  eventoEntryModel);
  }



  public void registerMOs(MOServer server, OctetString context) 
    throws DuplicateRegistrationException 
  {
    // Scalar Objects
    server.register(this.numeroEventos, context);
    server.register(this.eventoEntry, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
  }

  public void unregisterMOs(MOServer server, OctetString context) {
    // Scalar Objects
    server.unregister(this.numeroEventos, context);
    server.unregister(this.eventoEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
  }

  // Notifications

  // Scalars

  // Value Validators


  // Rows and Factories

  public class EventoEntryRow extends DefaultMOMutableRow2PC {

    //--AgentGen BEGIN=eventoEntry::RowMembers
    //--AgentGen END

    public EventoEntryRow(OID index, Variable[] values) {
      super(index, values);
    //--AgentGen BEGIN=eventoEntry::RowConstructor
    //--AgentGen END
    }
    
    public Counter32 getEventoIndex() {
    //--AgentGen BEGIN=eventoEntry::getEventoIndex
    //--AgentGen END
      return (Counter32) super.getValue(idxEventoIndex);
    }  
    
    public void setEventoIndex(Counter32 newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoIndex
    //--AgentGen END
      super.setValue(idxEventoIndex, newColValue);
    }
    
    public OctetString getEventoName() {
    //--AgentGen BEGIN=eventoEntry::getEventoName
    //--AgentGen END
      return (OctetString) super.getValue(idxEventoName);
    }  
    
    public void setEventoName(OctetString newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoName
    //--AgentGen END
      super.setValue(idxEventoName, newColValue);
    }
    
    public Integer32 getEventoEstado() {
    //--AgentGen BEGIN=eventoEntry::getEventoEstado
    //--AgentGen END
      return (Integer32) super.getValue(idxEventoEstado);
    }  
    
    public void setEventoEstado(Integer32 newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoEstado
    //--AgentGen END
      super.setValue(idxEventoEstado, newColValue);
    }
    
    public TimeTicks getEventoTempo() {
    //--AgentGen BEGIN=eventoEntry::getEventoTempo
    //--AgentGen END
      return (TimeTicks) super.getValue(idxEventoTempo);
    }  
    
    public void setEventoTempo(TimeTicks newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoTempo
    //--AgentGen END
      super.setValue(idxEventoTempo, newColValue);
    }
    
    public TimeTicks getEventoDuracao() {
    //--AgentGen BEGIN=eventoEntry::getEventoDuracao
    //--AgentGen END
      return (TimeTicks) super.getValue(idxEventoDuracao);
    }  
    
    public void setEventoDuracao(TimeTicks newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoDuracao
    //--AgentGen END
      super.setValue(idxEventoDuracao, newColValue);
    }
    
    public OctetString getEventoFrasePassado() {
    //--AgentGen BEGIN=eventoEntry::getEventoFrasePassado
    //--AgentGen END
      return (OctetString) super.getValue(idxEventoFrasePassado);
    }  
    
    public void setEventoFrasePassado(OctetString newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoFrasePassado
    //--AgentGen END
      super.setValue(idxEventoFrasePassado, newColValue);
    }
    
    public OctetString getEventoFrasePresente() {
    //--AgentGen BEGIN=eventoEntry::getEventoFrasePresente
    //--AgentGen END
      return (OctetString) super.getValue(idxEventoFrasePresente);
    }  
    
    public void setEventoFrasePresente(OctetString newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoFrasePresente
    //--AgentGen END
      super.setValue(idxEventoFrasePresente, newColValue);
    }
    
    public Integer32 getEventoFraseFuturo() {
    //--AgentGen BEGIN=eventoEntry::getEventoFraseFuturo
    //--AgentGen END
      return (Integer32) super.getValue(idxEventoFraseFuturo);
    }  
    
    public void setEventoFraseFuturo(Integer32 newColValue) {
    //--AgentGen BEGIN=eventoEntry::setEventoFraseFuturo
    //--AgentGen END
      super.setValue(idxEventoFraseFuturo, newColValue);
    }
    
    public Variable getValue(int column) {
    //--AgentGen BEGIN=eventoEntry::RowGetValue
    //--AgentGen END
        switch(column) {
            case idxEventoIndex:
        	    return getEventoIndex();
            case idxEventoName:
        	    return getEventoName();
            case idxEventoEstado:
        	    return getEventoEstado();
            case idxEventoTempo:
        	    return getEventoTempo();
            case idxEventoDuracao:
        	    return getEventoDuracao();
            case idxEventoFrasePassado:
        	    return getEventoFrasePassado();
            case idxEventoFrasePresente:
        	    return getEventoFrasePresente();
            case idxEventoFraseFuturo:
        	    return getEventoFraseFuturo();
            default:
                return super.getValue(column);
        }
    }
    
    public void setValue(int column, Variable value) {
    //--AgentGen BEGIN=eventoEntry::RowSetValue
    //--AgentGen END
        switch(column) {
            case idxEventoIndex:
        	    setEventoIndex((Counter32)value);
        	    break;
            case idxEventoName:
        	    setEventoName((OctetString)value);
        	    break;
            case idxEventoEstado:
        	    setEventoEstado((Integer32)value);
        	    break;
            case idxEventoTempo:
        	    setEventoTempo((TimeTicks)value);
        	    break;
            case idxEventoDuracao:
        	    setEventoDuracao((TimeTicks)value);
        	    break;
            case idxEventoFrasePassado:
        	    setEventoFrasePassado((OctetString)value);
        	    break;
            case idxEventoFrasePresente:
        	    setEventoFrasePresente((OctetString)value);
        	    break;
            case idxEventoFraseFuturo:
        	    setEventoFraseFuturo((Integer32)value);
        	    break;
            default:
                super.setValue(column, value);
            }
        }

    //--AgentGen BEGIN=eventoEntry::Row
    //--AgentGen END
    }
  
    public class EventoEntryRowFactory implements MOTableRowFactory<EventoEntryRow>
    {
        public synchronized EventoEntryRow createRow(OID index, Variable[] values)
            throws UnsupportedOperationException
        {
            EventoEntryRow row = new EventoEntryRow(index, values);
    //--AgentGen BEGIN=eventoEntry::createRow
    //--AgentGen END
            return row;
        }
    
        public synchronized void freeRow(EventoEntryRow row) {
    //--AgentGen BEGIN=eventoEntry::freeRow
    //--AgentGen END
        }

    //--AgentGen BEGIN=eventoEntry::RowFactory
    //--AgentGen END
    }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

  // Textual Definitions of MIB module GrEventosMib
  protected void addTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

  // Textual Definitions of other MIB modules
  public void addImportedTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


