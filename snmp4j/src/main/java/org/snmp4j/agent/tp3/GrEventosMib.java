/** Copyright Text */
package org.snmp4j.agent.tp3;
// --AgentGen BEGIN=_BEGIN
// --AgentGen END

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

// --AgentGen BEGIN=_IMPORT
// --AgentGen END

public class GrEventosMib
        // --AgentGen BEGIN=_EXTENDS
        // --AgentGen END
        implements MOGroup
// --AgentGen BEGIN=_IMPLEMENTS
// --AgentGen END
{

    private static final LogAdapter LOGGER = LogFactory.getLogger(GrEventosMib.class);

    // --AgentGen BEGIN=_STATIC
    // --AgentGen END

    // Factory
    private MOFactory moFactory = DefaultMOFactory.getInstance();

    // Constants

    /** OID of this MIB module for usage which can be used for its identification. */
    public static final OID oidGrEventosMib = new OID(new int[] {1, 3, 6, 1, 4, 1, 8888});

    // Identities
    // Scalars
    public static final OID oidNumeroEventos = new OID(new int[] {1, 3, 6, 1, 4, 1, 8888, 1, 0});
    // Tables

    // Notifications

    // Enumerations

    // TextualConventions

    // Scalars
    private MOScalar<Counter32> numeroEventos;

    // Tables
    public static final OID oidEventoEntry = new OID(new int[] {1, 3, 6, 1, 4, 1, 8888, 2, 1});

    // Index OID definitions
    public static final OID oidEventoIndex = new OID(new int[] {1, 3, 6, 1, 4, 1, 8888, 2, 1, 1});

    // Column TC definitions for eventoEntry:

    // Column sub-identifier definitions for eventoEntry:
    public static final int colEventoIndex = 1;
    public static final int colEventoName = 2;
    public static final int colEventoEstado = 3;
    public static final int colEventoTempoAnos = 4;
    public static final int colEventoTempoMeses = 5;
    public static final int colEventoTempoSemanas = 6;
    public static final int colEventoTempoDias = 7;
    public static final int colEventoTempoHoras = 8;
    public static final int colEventoTempoMinutos = 9;
    public static final int colEventoDuracao = 10;
    public static final int colEventoFrasePassado = 11;
    public static final int colEventoFrasePresente = 12;
    public static final int colEventoFraseFuturo = 13;

    // Column index definitions for eventoEntry:
    public static final int idxEventoIndex = 0;
    public static final int idxEventoName = 1;
    public static final int idxEventoEstado = 2;
    public static final int idxEventoTempoAnos = 3;
    public static final int idxEventoTempoMeses = 4;
    public static final int idxEventoTempoSemanas = 5;
    public static final int idxEventoTempoDias = 6;
    public static final int idxEventoTempoHoras = 7;
    public static final int idxEventoTempoMinutos = 8;
    public static final int idxEventoDuracao = 9;
    public static final int idxEventoFrasePassado = 10;
    public static final int idxEventoFrasePresente = 11;
    public static final int idxEventoFraseFuturo = 12;

    private MOTableSubIndex[] eventoEntryIndexes;
    private MOTableIndex eventoEntryIndex;

    @SuppressWarnings(value = {"rawtypes"})
    private MOTable<EventoEntryRow, MOColumn, MOTableModel<EventoEntryRow>> eventoEntry;

    private MOTableModel<EventoEntryRow> eventoEntryModel;

    // --AgentGen BEGIN=_MEMBERS
    // --AgentGen END

    /**
     * Constructs a GrEventosMib instance without actually creating its <code>ManagedObject</code>
     * instances. This has to be done in a sub-class constructor or after construction by calling
     * {@link #createMO(MOFactory moFactory)}.
     */
    protected GrEventosMib() {
        // --AgentGen BEGIN=_DEFAULTCONSTRUCTOR
        // --AgentGen END
    }

    /**
     * Constructs a GrEventosMib instance and actually creates its <code>ManagedObject</code>
     * instances using the supplied <code>MOFactory</code> (by calling {@link #createMO(MOFactory
     * moFactory)}).
     *
     * @param moFactory the <code>MOFactory</code> to be used to create the managed objects for this
     *     module.
     */
    public GrEventosMib(MOFactory moFactory) {
        this();
        // --AgentGen BEGIN=_FACTORYCONSTRUCTOR::factoryWrapper
        // --AgentGen END
        this.moFactory = moFactory;
        createMO(moFactory);
        // --AgentGen BEGIN=_FACTORYCONSTRUCTOR
        // --AgentGen END
    }

    // --AgentGen BEGIN=_CONSTRUCTORS
    // --AgentGen END

    /**
     * Create the ManagedObjects defined for this MIB module using the specified {@link MOFactory}.
     *
     * @param moFactory the <code>MOFactory</code> instance to use for object creation.
     */
    protected void createMO(MOFactory moFactory) {
        addTCsToFactory(moFactory);
        numeroEventos =
                moFactory.createScalar(
                        oidNumeroEventos,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                        new Counter32());
        createEventoEntry(moFactory);
    }

    public MOScalar<Counter32> getNumeroEventos() {
        return numeroEventos;
    }

    @SuppressWarnings(value = {"rawtypes"})
    public MOTable<EventoEntryRow, MOColumn, MOTableModel<EventoEntryRow>> getEventoEntry() {
        return eventoEntry;
    }

    @SuppressWarnings(value = {"unchecked"})
    private void createEventoEntry(MOFactory moFactory) {
        // Index definition
        eventoEntryIndexes =
                new MOTableSubIndex[] {
                    moFactory.createSubIndex(oidEventoIndex, SMIConstants.SYNTAX_INTEGER, 1, 1)
                };

        eventoEntryIndex =
                moFactory.createIndex(
                        eventoEntryIndexes,
                        false,
                        new MOTableIndexValidator() {
                            public boolean isValidIndex(OID index) {
                                boolean isValidIndex = true;
                                // --AgentGen BEGIN=eventoEntry::isValidIndex
                                // --AgentGen END
                                return isValidIndex;
                            }
                        });

        // Columns
        MOColumn<?>[] eventoEntryColumns = new MOColumn<?>[13];
        eventoEntryColumns[idxEventoIndex] =
                moFactory.createColumn(
                        colEventoIndex,
                        SMIConstants.SYNTAX_COUNTER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoName] =
                moFactory.createColumn(
                        colEventoName,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoEstado] =
                moFactory.createColumn(
                        colEventoEstado,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempoAnos] =
                moFactory.createColumn(
                        colEventoTempoAnos,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempoMeses] =
                moFactory.createColumn(
                        colEventoTempoMeses,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempoSemanas] =
                moFactory.createColumn(
                        colEventoTempoSemanas,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempoDias] =
                moFactory.createColumn(
                        colEventoTempoDias,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempoHoras] =
                moFactory.createColumn(
                        colEventoTempoHoras,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoTempoMinutos] =
                moFactory.createColumn(
                        colEventoTempoMinutos,
                        SMIConstants.SYNTAX_INTEGER,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoDuracao] =
                moFactory.createColumn(
                        colEventoDuracao,
                        SMIConstants.SYNTAX_TIMETICKS,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoFrasePassado] =
                moFactory.createColumn(
                        colEventoFrasePassado,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoFrasePresente] =
                moFactory.createColumn(
                        colEventoFrasePresente,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        eventoEntryColumns[idxEventoFraseFuturo] =
                moFactory.createColumn(
                        colEventoFraseFuturo,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
        // Table model
        eventoEntryModel =
                moFactory.createTableModel(oidEventoEntry, eventoEntryIndex, eventoEntryColumns);
        ((MOMutableTableModel<EventoEntryRow>) eventoEntryModel)
                .setRowFactory(new EventoEntryRowFactory());
        eventoEntry =
                moFactory.createTable(
                        oidEventoEntry, eventoEntryIndex, eventoEntryColumns, eventoEntryModel);
    }

    public void registerMOs(MOServer server, OctetString context)
            throws DuplicateRegistrationException {
        // Scalar Objects
        server.register(this.numeroEventos, context);
        server.register(this.eventoEntry, context);
        // --AgentGen BEGIN=_registerMOs
        // --AgentGen END
    }

    public void unregisterMOs(MOServer server, OctetString context) {
        // Scalar Objects
        server.unregister(this.numeroEventos, context);
        server.unregister(this.eventoEntry, context);
        // --AgentGen BEGIN=_unregisterMOs
        // --AgentGen END
    }

    // Notifications

    // Scalars

    // Value Validators

    // Rows and Factories

    public class EventoEntryRow extends DefaultMOMutableRow2PC {

        // --AgentGen BEGIN=eventoEntry::RowMembers
        // --AgentGen END

        public EventoEntryRow(OID index, Variable[] values) {
            super(index, values);
            // --AgentGen BEGIN=eventoEntry::RowConstructor
            // --AgentGen END
        }

        public Counter32 getEventoIndex() {
            // --AgentGen BEGIN=eventoEntry::getEventoIndex
            // --AgentGen END
            return (Counter32) super.getValue(idxEventoIndex);
        }

        public void setEventoIndex(Counter32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoIndex
            // --AgentGen END
            super.setValue(idxEventoIndex, newColValue);
        }

        public OctetString getEventoName() {
            // --AgentGen BEGIN=eventoEntry::getEventoName
            // --AgentGen END
            return (OctetString) super.getValue(idxEventoName);
        }

        public void setEventoName(OctetString newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoName
            // --AgentGen END
            super.setValue(idxEventoName, newColValue);
        }

        public Integer32 getEventoEstado() {
            // --AgentGen BEGIN=eventoEntry::getEventoEstado
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoEstado);
        }

        public void setEventoEstado(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoEstado
            // --AgentGen END
            super.setValue(idxEventoEstado, newColValue);
        }

        public Integer32 getEventoTempoAnos() {
            // --AgentGen BEGIN=eventoEntry::getEventoTempoAnos
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoTempoAnos);
        }

        public void setEventoTempoAnos(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoTempoAnos
            // --AgentGen END
            super.setValue(idxEventoTempoAnos, newColValue);
        }

        public Integer32 getEventoTempoMeses() {
            // --AgentGen BEGIN=eventoEntry::getEventoTempoMeses
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoTempoMeses);
        }

        public void setEventoTempoMeses(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoTempoMeses
            // --AgentGen END
            super.setValue(idxEventoTempoMeses, newColValue);
        }

        public Integer32 getEventoTempoSemanas() {
            // --AgentGen BEGIN=eventoEntry::getEventoTempoSemanas
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoTempoSemanas);
        }

        public void setEventoTempoSemanas(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoTempoSemanas
            // --AgentGen END
            super.setValue(idxEventoTempoSemanas, newColValue);
        }

        public Integer32 getEventoTempoDias() {
            // --AgentGen BEGIN=eventoEntry::getEventoTempoDias
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoTempoDias);
        }

        public void setEventoTempoDias(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoTempoDias
            // --AgentGen END
            super.setValue(idxEventoTempoDias, newColValue);
        }

        public Integer32 getEventoTempoHoras() {
            // --AgentGen BEGIN=eventoEntry::getEventoTempoHoras
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoTempoHoras);
        }

        public void setEventoTempoHoras(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoTempoHoras
            // --AgentGen END
            super.setValue(idxEventoTempoHoras, newColValue);
        }

        public Integer32 getEventoTempoMinutos() {
            // --AgentGen BEGIN=eventoEntry::getEventoTempoMinutos
            // --AgentGen END
            return (Integer32) super.getValue(idxEventoTempoMinutos);
        }

        public void setEventoTempoMinutos(Integer32 newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoTempoMinutos
            // --AgentGen END
            super.setValue(idxEventoTempoMinutos, newColValue);
        }

        public TimeTicks getEventoDuracao() {
            // --AgentGen BEGIN=eventoEntry::getEventoDuracao
            // --AgentGen END
            return (TimeTicks) super.getValue(idxEventoDuracao);
        }

        public void setEventoDuracao(TimeTicks newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoDuracao
            // --AgentGen END
            super.setValue(idxEventoDuracao, newColValue);
        }

        public OctetString getEventoFrasePassado() {
            // --AgentGen BEGIN=eventoEntry::getEventoFrasePassado
            // --AgentGen END
            return (OctetString) super.getValue(idxEventoFrasePassado);
        }

        public void setEventoFrasePassado(OctetString newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoFrasePassado
            // --AgentGen END
            super.setValue(idxEventoFrasePassado, newColValue);
        }

        public OctetString getEventoFrasePresente() {
            // --AgentGen BEGIN=eventoEntry::getEventoFrasePresente
            // --AgentGen END
            return (OctetString) super.getValue(idxEventoFrasePresente);
        }

        public void setEventoFrasePresente(OctetString newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoFrasePresente
            // --AgentGen END
            super.setValue(idxEventoFrasePresente, newColValue);
        }

        public OctetString getEventoFraseFuturo() {
            // --AgentGen BEGIN=eventoEntry::getEventoFraseFuturo
            // --AgentGen END
            return (OctetString) super.getValue(idxEventoFraseFuturo);
        }

        public void setEventoFraseFuturo(OctetString newColValue) {
            // --AgentGen BEGIN=eventoEntry::setEventoFraseFuturo
            // --AgentGen END
            super.setValue(idxEventoFraseFuturo, newColValue);
        }

        public Variable getValue(int column) {
            // --AgentGen BEGIN=eventoEntry::RowGetValue
            // --AgentGen END
            switch (column) {
                case idxEventoIndex:
                    return getEventoIndex();
                case idxEventoName:
                    return getEventoName();
                case idxEventoEstado:
                    return getEventoEstado();
                case idxEventoTempoAnos:
                    return getEventoTempoAnos();
                case idxEventoTempoMeses:
                    return getEventoTempoMeses();
                case idxEventoTempoSemanas:
                    return getEventoTempoSemanas();
                case idxEventoTempoDias:
                    return getEventoTempoDias();
                case idxEventoTempoHoras:
                    return getEventoTempoHoras();
                case idxEventoTempoMinutos:
                    return getEventoTempoMinutos();
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
            // --AgentGen BEGIN=eventoEntry::RowSetValue
            // --AgentGen END
            switch (column) {
                case idxEventoIndex:
                    setEventoIndex((Counter32) value);
                    break;
                case idxEventoName:
                    setEventoName((OctetString) value);
                    break;
                case idxEventoEstado:
                    setEventoEstado((Integer32) value);
                    break;
                case idxEventoTempoAnos:
                    setEventoTempoAnos((Integer32) value);
                    break;
                case idxEventoTempoMeses:
                    setEventoTempoMeses((Integer32) value);
                    break;
                case idxEventoTempoSemanas:
                    setEventoTempoSemanas((Integer32) value);
                    break;
                case idxEventoTempoDias:
                    setEventoTempoDias((Integer32) value);
                    break;
                case idxEventoTempoHoras:
                    setEventoTempoHoras((Integer32) value);
                    break;
                case idxEventoTempoMinutos:
                    setEventoTempoMinutos((Integer32) value);
                    break;
                case idxEventoDuracao:
                    setEventoDuracao((TimeTicks) value);
                    break;
                case idxEventoFrasePassado:
                    setEventoFrasePassado((OctetString) value);
                    break;
                case idxEventoFrasePresente:
                    setEventoFrasePresente((OctetString) value);
                    break;
                case idxEventoFraseFuturo:
                    setEventoFraseFuturo((OctetString) value);
                    break;
                default:
                    super.setValue(column, value);
            }
        }

        // --AgentGen BEGIN=eventoEntry::Row
        // --AgentGen END
    }

    public class EventoEntryRowFactory implements MOTableRowFactory<EventoEntryRow> {
        public synchronized EventoEntryRow createRow(OID index, Variable[] values)
                throws UnsupportedOperationException {
            EventoEntryRow row = new EventoEntryRow(index, values);
            // --AgentGen BEGIN=eventoEntry::createRow
            // --AgentGen END
            return row;
        }

        public synchronized void freeRow(EventoEntryRow row) {
            // --AgentGen BEGIN=eventoEntry::freeRow
            // --AgentGen END
        }

        // --AgentGen BEGIN=eventoEntry::RowFactory
        // --AgentGen END
    }

    // --AgentGen BEGIN=_METHODS
    // --AgentGen END

    // Textual Definitions of MIB module GrEventosMib
    protected void addTCsToFactory(MOFactory moFactory) {}

    // --AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
    // --AgentGen END

    // Textual Definitions of other MIB modules
    public void addImportedTCsToFactory(MOFactory moFactory) {}

    // --AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
    // --AgentGen END

    // --AgentGen BEGIN=_CLASSES
    // --AgentGen END

    // --AgentGen BEGIN=_END
    // --AgentGen END
}
