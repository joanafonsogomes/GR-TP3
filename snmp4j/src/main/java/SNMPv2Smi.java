/** Copyright Text */
// --AgentGen BEGIN=_BEGIN
// --AgentGen END

import org.snmp4j.smi.*;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;

// --AgentGen BEGIN=_IMPORT
// --AgentGen END

public class SNMPv2Smi
        // --AgentGen BEGIN=_EXTENDS
        // --AgentGen END
        implements MOGroup
// --AgentGen BEGIN=_IMPLEMENTS
// --AgentGen END
{

    private static final LogAdapter LOGGER = LogFactory.getLogger(SNMPv2Smi.class);

    // --AgentGen BEGIN=_STATIC
    // --AgentGen END

    // Factory
    private MOFactory moFactory = DefaultMOFactory.getInstance();

    // Constants

    /** OID of this MIB module for usage which can be used for its identification. */
    public static final OID oidSNMPv2Smi = new OID(new int[] {});

    // Identities
    public static final OID oidZeroDotZero = new OID(new int[] {0, 0});
    // Scalars
    // Tables

    // Notifications

    // Enumerations

    // TextualConventions

    // Scalars

    // Tables

    // --AgentGen BEGIN=_MEMBERS
    // --AgentGen END

    /**
     * Constructs a SNMPv2Smi instance without actually creating its <code>ManagedObject</code>
     * instances. This has to be done in a sub-class constructor or after construction by calling
     * {@link #createMO(MOFactory moFactory)}.
     */
    protected SNMPv2Smi() {
        // --AgentGen BEGIN=_DEFAULTCONSTRUCTOR
        // --AgentGen END
    }

    /**
     * Constructs a SNMPv2Smi instance and actually creates its <code>ManagedObject</code> instances
     * using the supplied <code>MOFactory</code> (by calling {@link #createMO(MOFactory
     * moFactory)}).
     *
     * @param moFactory the <code>MOFactory</code> to be used to create the managed objects for this
     *     module.
     */
    public SNMPv2Smi(MOFactory moFactory) {
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
    }

    public void registerMOs(MOServer server, OctetString context)
            throws DuplicateRegistrationException {
        // Scalar Objects
        // --AgentGen BEGIN=_registerMOs
        // --AgentGen END
    }

    public void unregisterMOs(MOServer server, OctetString context) {
        // Scalar Objects
        // --AgentGen BEGIN=_unregisterMOs
        // --AgentGen END
    }

    // Notifications

    // Scalars

    // Value Validators

    // Rows and Factories

    // --AgentGen BEGIN=_METHODS
    // --AgentGen END

    // Textual Definitions of MIB module SNMPv2Smi
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
