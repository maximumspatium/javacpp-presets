// Targeted by JavaCPP version 1.1-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

public class LLVM extends org.bytedeco.javacpp.presets.LLVM {
    static { Loader.load(); }

// Parsed from <llvm-c/Support.h>

/*===-- llvm-c/Support.h - Support C Interface --------------------*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This file defines the C interface to the LLVM support library.             *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_SUPPORT_H
// #define LLVM_C_SUPPORT_H

// #include "llvm/Support/DataTypes.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCSupportTypes Types and Enumerations
 *
 * @{
 */

/**
 * Used to pass regions of memory through LLVM interfaces.
 *
 * @see llvm::MemoryBuffer
 */
@Name("LLVMOpaqueMemoryBuffer") @Opaque public static class LLVMMemoryBufferRef extends Pointer {
    /** Empty constructor. */
    public LLVMMemoryBufferRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMMemoryBufferRef(Pointer p) { super(p); }
}

/**
 * @}
 */

/**
 * This function permanently loads the dynamic library at the given path.
 * It is safe to call this function multiple times for the same library.
 *
 * @see sys::DynamicLibrary::LoadLibraryPermanently()
  */
public static native @Cast("LLVMBool") int LLVMLoadLibraryPermanently(@Cast("const char*") BytePointer Filename);
public static native @Cast("LLVMBool") int LLVMLoadLibraryPermanently(String Filename);

/**
 * This function parses the given arguments using the LLVM command line parser.
 * Note that the only stable thing about this function is its signature; you
 * cannot rely on any particular set of command line arguments being interpreted
 * the same way across LLVM versions.
 *
 * @see llvm::cl::ParseCommandLineOptions()
 */
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") PointerPointer argv,
                                 @Cast("const char*") BytePointer Overview);
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") @ByPtrPtr BytePointer argv,
                                 @Cast("const char*") BytePointer Overview);
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") @ByPtrPtr ByteBuffer argv,
                                 String Overview);
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") @ByPtrPtr byte[] argv,
                                 @Cast("const char*") BytePointer Overview);
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") @ByPtrPtr BytePointer argv,
                                 String Overview);
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") @ByPtrPtr ByteBuffer argv,
                                 @Cast("const char*") BytePointer Overview);
public static native void LLVMParseCommandLineOptions(int argc, @Cast("const char*const*") @ByPtrPtr byte[] argv,
                                 String Overview);

/**
 * This function will search through all previously loaded dynamic
 * libraries for the symbol \p symbolName. If it is found, the address of
 * that symbol is returned. If not, null is returned.
 *
 * @see sys::DynamicLibrary::SearchForAddressOfSymbol()
 */
public static native Pointer LLVMSearchForAddressOfSymbol(@Cast("const char*") BytePointer symbolName);
public static native Pointer LLVMSearchForAddressOfSymbol(String symbolName);

/**
 * This functions permanently adds the symbol \p symbolName with the
 * value \p symbolValue.  These symbols are searched before any
 * libraries.
 *
 * @see sys::DynamicLibrary::AddSymbol()
 */
public static native void LLVMAddSymbol(@Cast("const char*") BytePointer symbolName, Pointer symbolValue);
public static native void LLVMAddSymbol(String symbolName, Pointer symbolValue);

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/Core.h>

/*===-- llvm-c/Core.h - Core Library C Interface ------------------*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMCore.a, which implements    *|
|* the LLVM intermediate representation.                                      *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_CORE_H
// #define LLVM_C_CORE_H

// #include "llvm-c/Support.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMC LLVM-C: C interface to LLVM
 *
 * This module exposes parts of the LLVM library as a C API.
 *
 * @{
 */

/**
 * @defgroup LLVMCTransforms Transforms
 */

/**
 * @defgroup LLVMCCore Core
 *
 * This modules provide an interface to libLLVMCore, which implements
 * the LLVM intermediate representation as well as other related types
 * and utilities.
 *
 * LLVM uses a polymorphic type hierarchy which C cannot represent, therefore
 * parameters must be passed as base types. Despite the declared types, most
 * of the functions provided operate only on branches of the type hierarchy.
 * The declared parameter names are descriptive and specify which type is
 * required. Additionally, each type hierarchy is documented along with the
 * functions that operate upon it. For more detail, refer to LLVM's C++ code.
 * If in doubt, refer to Core.cpp, which performs parameter downcasts in the
 * form unwrap<RequiredType>(Param).
 *
 * Many exotic languages can interoperate with C code but have a harder time
 * with C++ due to name mangling. So in addition to C, this interface enables
 * tools written in such languages.
 *
 * @{
 */

/**
 * @defgroup LLVMCCoreTypes Types and Enumerations
 *
 * @{
 */

/* Opaque types. */

/**
 * The top-level container for all LLVM global data. See the LLVMContext class.
 */
@Name("LLVMOpaqueContext") @Opaque public static class LLVMContextRef extends Pointer {
    /** Empty constructor. */
    public LLVMContextRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMContextRef(Pointer p) { super(p); }
}

/**
 * The top-level container for all other LLVM Intermediate Representation (IR)
 * objects.
 *
 * @see llvm::Module
 */
@Name("LLVMOpaqueModule") @Opaque public static class LLVMModuleRef extends Pointer {
    /** Empty constructor. */
    public LLVMModuleRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMModuleRef(Pointer p) { super(p); }
}

/**
 * Each value in the LLVM IR has a type, an LLVMTypeRef.
 *
 * @see llvm::Type
 */
@Name("LLVMOpaqueType") @Opaque public static class LLVMTypeRef extends Pointer {
    /** Empty constructor. */
    public LLVMTypeRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMTypeRef(Pointer p) { super(p); }
}

/**
 * Represents an individual value in LLVM IR.
 *
 * This models llvm::Value.
 */
@Name("LLVMOpaqueValue") @Opaque public static class LLVMValueRef extends Pointer {
    /** Empty constructor. */
    public LLVMValueRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMValueRef(Pointer p) { super(p); }
}

/**
 * Represents a basic block of instructions in LLVM IR.
 *
 * This models llvm::BasicBlock.
 */
@Name("LLVMOpaqueBasicBlock") @Opaque public static class LLVMBasicBlockRef extends Pointer {
    /** Empty constructor. */
    public LLVMBasicBlockRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMBasicBlockRef(Pointer p) { super(p); }
}

/**
 * Represents an LLVM basic block builder.
 *
 * This models llvm::IRBuilder.
 */
@Name("LLVMOpaqueBuilder") @Opaque public static class LLVMBuilderRef extends Pointer {
    /** Empty constructor. */
    public LLVMBuilderRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMBuilderRef(Pointer p) { super(p); }
}

/**
 * Interface used to provide a module to JIT or interpreter.
 * This is now just a synonym for llvm::Module, but we have to keep using the
 * different type to keep binary compatibility.
 */
@Name("LLVMOpaqueModuleProvider") @Opaque public static class LLVMModuleProviderRef extends Pointer {
    /** Empty constructor. */
    public LLVMModuleProviderRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMModuleProviderRef(Pointer p) { super(p); }
}

/** @see llvm::PassManagerBase */
@Name("LLVMOpaquePassManager") @Opaque public static class LLVMPassManagerRef extends Pointer {
    /** Empty constructor. */
    public LLVMPassManagerRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMPassManagerRef(Pointer p) { super(p); }
}

/** @see llvm::PassRegistry */
@Name("LLVMOpaquePassRegistry") @Opaque public static class LLVMPassRegistryRef extends Pointer {
    /** Empty constructor. */
    public LLVMPassRegistryRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMPassRegistryRef(Pointer p) { super(p); }
}

/**
 * Used to get the users and usees of a Value.
 *
 * @see llvm::Use */
@Name("LLVMOpaqueUse") @Opaque public static class LLVMUseRef extends Pointer {
    /** Empty constructor. */
    public LLVMUseRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMUseRef(Pointer p) { super(p); }
}


/**
 * @see llvm::DiagnosticInfo
 */
@Name("LLVMOpaqueDiagnosticInfo") @Opaque public static class LLVMDiagnosticInfoRef extends Pointer {
    /** Empty constructor. */
    public LLVMDiagnosticInfoRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMDiagnosticInfoRef(Pointer p) { super(p); }
}

/** enum LLVMAttribute */
public static final int
    LLVMZExtAttribute       =  1<<0,
    LLVMSExtAttribute       =  1<<1,
    LLVMNoReturnAttribute   =  1<<2,
    LLVMInRegAttribute      =  1<<3,
    LLVMStructRetAttribute  =  1<<4,
    LLVMNoUnwindAttribute   =  1<<5,
    LLVMNoAliasAttribute    =  1<<6,
    LLVMByValAttribute      =  1<<7,
    LLVMNestAttribute       =  1<<8,
    LLVMReadNoneAttribute   =  1<<9,
    LLVMReadOnlyAttribute   =  1<<10,
    LLVMNoInlineAttribute   =  1<<11,
    LLVMAlwaysInlineAttribute    =  1<<12,
    LLVMOptimizeForSizeAttribute =  1<<13,
    LLVMStackProtectAttribute    =  1<<14,
    LLVMStackProtectReqAttribute =  1<<15,
    LLVMAlignment =  31<<16,
    LLVMNoCaptureAttribute  =  1<<21,
    LLVMNoRedZoneAttribute  =  1<<22,
    LLVMNoImplicitFloatAttribute =  1<<23,
    LLVMNakedAttribute      =  1<<24,
    LLVMInlineHintAttribute =  1<<25,
    LLVMStackAlignment =  7<<26,
    LLVMReturnsTwice =  1 << 29,
    LLVMUWTable =  1 << 30,
    LLVMNonLazyBind =  1 << 31;

    /* FIXME: These attributes are currently not included in the C API as
       a temporary measure until the API/ABI impact to the C API is understood
       and the path forward agreed upon.
    LLVMSanitizeAddressAttribute = 1ULL << 32,
    LLVMStackProtectStrongAttribute = 1ULL<<35,
    LLVMColdAttribute = 1ULL << 40,
    LLVMOptimizeNoneAttribute = 1ULL << 42,
    LLVMInAllocaAttribute = 1ULL << 43,
    LLVMNonNullAttribute = 1ULL << 44,
    LLVMJumpTableAttribute = 1ULL << 45,
    LLVMConvergentAttribute = 1ULL << 46,
    LLVMSafeStackAttribute = 1ULL << 47,
    */

/** enum LLVMOpcode */
public static final int
  /* Terminator Instructions */
  LLVMRet            = 1,
  LLVMBr             = 2,
  LLVMSwitch         = 3,
  LLVMIndirectBr     = 4,
  LLVMInvoke         = 5,
  /* removed 6 due to API changes */
  LLVMUnreachable    = 7,

  /* Standard Binary Operators */
  LLVMAdd            = 8,
  LLVMFAdd           = 9,
  LLVMSub            = 10,
  LLVMFSub           = 11,
  LLVMMul            = 12,
  LLVMFMul           = 13,
  LLVMUDiv           = 14,
  LLVMSDiv           = 15,
  LLVMFDiv           = 16,
  LLVMURem           = 17,
  LLVMSRem           = 18,
  LLVMFRem           = 19,

  /* Logical Operators */
  LLVMShl            = 20,
  LLVMLShr           = 21,
  LLVMAShr           = 22,
  LLVMAnd            = 23,
  LLVMOr             = 24,
  LLVMXor            = 25,

  /* Memory Operators */
  LLVMAlloca         = 26,
  LLVMLoad           = 27,
  LLVMStore          = 28,
  LLVMGetElementPtr  = 29,

  /* Cast Operators */
  LLVMTrunc          = 30,
  LLVMZExt           = 31,
  LLVMSExt           = 32,
  LLVMFPToUI         = 33,
  LLVMFPToSI         = 34,
  LLVMUIToFP         = 35,
  LLVMSIToFP         = 36,
  LLVMFPTrunc        = 37,
  LLVMFPExt          = 38,
  LLVMPtrToInt       = 39,
  LLVMIntToPtr       = 40,
  LLVMBitCast        = 41,
  LLVMAddrSpaceCast  = 60,

  /* Other Operators */
  LLVMICmp           = 42,
  LLVMFCmp           = 43,
  LLVMPHI            = 44,
  LLVMCall           = 45,
  LLVMSelect         = 46,
  LLVMUserOp1        = 47,
  LLVMUserOp2        = 48,
  LLVMVAArg          = 49,
  LLVMExtractElement = 50,
  LLVMInsertElement  = 51,
  LLVMShuffleVector  = 52,
  LLVMExtractValue   = 53,
  LLVMInsertValue    = 54,

  /* Atomic operators */
  LLVMFence          = 55,
  LLVMAtomicCmpXchg  = 56,
  LLVMAtomicRMW      = 57,

  /* Exception Handling Operators */
  LLVMResume         = 58,
  LLVMLandingPad     = 59;

/** enum LLVMTypeKind */
public static final int
  /** type with no size */
  LLVMVoidTypeKind = 0,
  /** 16 bit floating point type */
  LLVMHalfTypeKind = 1,
  /** 32 bit floating point type */
  LLVMFloatTypeKind = 2,
  /** 64 bit floating point type */
  LLVMDoubleTypeKind = 3,
  /** 80 bit floating point type (X87) */
  LLVMX86_FP80TypeKind = 4,
  /** 128 bit floating point type (112-bit mantissa)*/
  LLVMFP128TypeKind = 5,
  /** 128 bit floating point type (two 64-bits) */
  LLVMPPC_FP128TypeKind = 6,
  /** Labels */
  LLVMLabelTypeKind = 7,
  /** Arbitrary bit width integers */
  LLVMIntegerTypeKind = 8,
  /** Functions */
  LLVMFunctionTypeKind = 9,
  /** Structures */
  LLVMStructTypeKind = 10,
  /** Arrays */
  LLVMArrayTypeKind = 11,
  /** Pointers */
  LLVMPointerTypeKind = 12,
  /** SIMD 'packed' format, or other vector type */
  LLVMVectorTypeKind = 13,
  /** Metadata */
  LLVMMetadataTypeKind = 14,
  /** X86 MMX */
  LLVMX86_MMXTypeKind = 15;

/** enum LLVMLinkage */
public static final int
  /** Externally visible function */
  LLVMExternalLinkage = 0,
  LLVMAvailableExternallyLinkage = 1,
  /** Keep one copy of function when linking (inline)*/
  LLVMLinkOnceAnyLinkage = 2,
  /** Same, but only replaced by something
                            equivalent. */
  LLVMLinkOnceODRLinkage = 3,
  /** Obsolete */
  LLVMLinkOnceODRAutoHideLinkage = 4,
  /** Keep one copy of function when linking (weak) */
  LLVMWeakAnyLinkage = 5,
  /** Same, but only replaced by something
                            equivalent. */
  LLVMWeakODRLinkage = 6,
  /** Special purpose, only applies to global arrays */
  LLVMAppendingLinkage = 7,
  /** Rename collisions when linking (static
                               functions) */
  LLVMInternalLinkage = 8,
  /** Like Internal, but omit from symbol table */
  LLVMPrivateLinkage = 9,
  /** Obsolete */
  LLVMDLLImportLinkage = 10,
  /** Obsolete */
  LLVMDLLExportLinkage = 11,
  /** ExternalWeak linkage description */
  LLVMExternalWeakLinkage = 12,
  /** Obsolete */
  LLVMGhostLinkage = 13,
  /** Tentative definitions */
  LLVMCommonLinkage = 14,
  /** Like Private, but linker removes. */
  LLVMLinkerPrivateLinkage = 15,
  /** Like LinkerPrivate, but is weak. */
  LLVMLinkerPrivateWeakLinkage = 16;

/** enum LLVMVisibility */
public static final int
  /** The GV is visible */
  LLVMDefaultVisibility = 0,
  /** The GV is hidden */
  LLVMHiddenVisibility = 1,
  /** The GV is protected */
  LLVMProtectedVisibility = 2;

/** enum LLVMDLLStorageClass */
public static final int
  LLVMDefaultStorageClass   = 0,
  /** Function to be imported from DLL. */
  LLVMDLLImportStorageClass = 1,
  /** Function to be accessible from DLL. */
  LLVMDLLExportStorageClass = 2;

/** enum LLVMCallConv */
public static final int
  LLVMCCallConv           = 0,
  LLVMFastCallConv        = 8,
  LLVMColdCallConv        = 9,
  LLVMWebKitJSCallConv    = 12,
  LLVMAnyRegCallConv      = 13,
  LLVMX86StdcallCallConv  = 64,
  LLVMX86FastcallCallConv = 65;

/** enum LLVMIntPredicate */
public static final int
  /** equal */
  LLVMIntEQ = 32,
  /** not equal */
  LLVMIntNE = 33,
  /** unsigned greater than */
  LLVMIntUGT = 34,
  /** unsigned greater or equal */
  LLVMIntUGE = 35,
  /** unsigned less than */
  LLVMIntULT = 36,
  /** unsigned less or equal */
  LLVMIntULE = 37,
  /** signed greater than */
  LLVMIntSGT = 38,
  /** signed greater or equal */
  LLVMIntSGE = 39,
  /** signed less than */
  LLVMIntSLT = 40,
  /** signed less or equal */
  LLVMIntSLE = 41;

/** enum LLVMRealPredicate */
public static final int
  /** Always false (always folded) */
  LLVMRealPredicateFalse = 0,
  /** True if ordered and equal */
  LLVMRealOEQ = 1,
  /** True if ordered and greater than */
  LLVMRealOGT = 2,
  /** True if ordered and greater than or equal */
  LLVMRealOGE = 3,
  /** True if ordered and less than */
  LLVMRealOLT = 4,
  /** True if ordered and less than or equal */
  LLVMRealOLE = 5,
  /** True if ordered and operands are unequal */
  LLVMRealONE = 6,
  /** True if ordered (no nans) */
  LLVMRealORD = 7,
  /** True if unordered: isnan(X) | isnan(Y) */
  LLVMRealUNO = 8,
  /** True if unordered or equal */
  LLVMRealUEQ = 9,
  /** True if unordered or greater than */
  LLVMRealUGT = 10,
  /** True if unordered, greater than, or equal */
  LLVMRealUGE = 11,
  /** True if unordered or less than */
  LLVMRealULT = 12,
  /** True if unordered, less than, or equal */
  LLVMRealULE = 13,
  /** True if unordered or not equal */
  LLVMRealUNE = 14,
  /** Always true (always folded) */
  LLVMRealPredicateTrue = 15;

/** enum LLVMLandingPadClauseTy */
public static final int
  /** A catch clause   */
  LLVMLandingPadCatch = 0,
  /** A filter clause  */
  LLVMLandingPadFilter = 1;

/** enum LLVMThreadLocalMode */
public static final int
  LLVMNotThreadLocal = 0,
  LLVMGeneralDynamicTLSModel = 1,
  LLVMLocalDynamicTLSModel = 2,
  LLVMInitialExecTLSModel = 3,
  LLVMLocalExecTLSModel = 4;

/** enum LLVMAtomicOrdering */
public static final int
  /** A load or store which is not atomic */
  LLVMAtomicOrderingNotAtomic = 0,
  /** Lowest level of atomicity, guarantees
                                     somewhat sane results, lock free. */
  LLVMAtomicOrderingUnordered = 1,
  /** guarantees that if you take all the
                                     operations affecting a specific address,
                                     a consistent ordering exists */
  LLVMAtomicOrderingMonotonic = 2,
  /** Acquire provides a barrier of the sort
                                   necessary to acquire a lock to access other
                                   memory with normal loads and stores. */
  LLVMAtomicOrderingAcquire = 4,
  /** Release is similar to Acquire, but with
                                   a barrier of the sort necessary to release
                                   a lock. */
  LLVMAtomicOrderingRelease = 5,
  /** provides both an Acquire and a
                                          Release barrier (for fences and
                                          operations which both read and write
                                           memory). */
  LLVMAtomicOrderingAcquireRelease = 6,
  /** provides Acquire semantics
                                                 for loads and Release
                                                 semantics for stores.
                                                 Additionally, it guarantees
                                                 that a total ordering exists
                                                 between all
                                                 SequentiallyConsistent
                                                 operations. */
  LLVMAtomicOrderingSequentiallyConsistent = 7;

/** enum LLVMAtomicRMWBinOp */
public static final int
    /** Set the new value and return the one old */
    LLVMAtomicRMWBinOpXchg = 0,
    /** Add a value and return the old one */
    LLVMAtomicRMWBinOpAdd = 1,
    /** Subtract a value and return the old one */
    LLVMAtomicRMWBinOpSub = 2,
    /** And a value and return the old one */
    LLVMAtomicRMWBinOpAnd = 3,
    /** Not-And a value and return the old one */
    LLVMAtomicRMWBinOpNand = 4,
    /** OR a value and return the old one */
    LLVMAtomicRMWBinOpOr = 5,
    /** Xor a value and return the old one */
    LLVMAtomicRMWBinOpXor = 6,
    /** Sets the value if it's greater than the
                             original using a signed comparison and return
                             the old one */
    LLVMAtomicRMWBinOpMax = 7,
    /** Sets the value if it's Smaller than the
                             original using a signed comparison and return
                             the old one */
    LLVMAtomicRMWBinOpMin = 8,
    /** Sets the value if it's greater than the
                             original using an unsigned comparison and return
                             the old one */
    LLVMAtomicRMWBinOpUMax = 9,
    /** Sets the value if it's greater than the
                             original using an unsigned comparison  and return
                             the old one */
    LLVMAtomicRMWBinOpUMin = 10;

/** enum LLVMDiagnosticSeverity */
public static final int
    LLVMDSError = 0,
    LLVMDSWarning = 1,
    LLVMDSRemark = 2,
    LLVMDSNote = 3;

/**
 * @}
 */

public static native void LLVMInitializeCore(LLVMPassRegistryRef R);

/** Deallocate and destroy all ManagedStatic variables.
    @see llvm::llvm_shutdown
    @see ManagedStatic */
public static native void LLVMShutdown();


/*===-- Error handling ----------------------------------------------------===*/

public static native @Cast("char*") BytePointer LLVMCreateMessage(@Cast("const char*") BytePointer Message);
public static native @Cast("char*") ByteBuffer LLVMCreateMessage(String Message);
public static native void LLVMDisposeMessage(@Cast("char*") BytePointer Message);
public static native void LLVMDisposeMessage(@Cast("char*") ByteBuffer Message);
public static native void LLVMDisposeMessage(@Cast("char*") byte[] Message);

public static class LLVMFatalErrorHandler extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMFatalErrorHandler(Pointer p) { super(p); }
    protected LLVMFatalErrorHandler() { allocate(); }
    private native void allocate();
    public native void call(@Cast("const char*") BytePointer Reason);
}

/**
 * Install a fatal error handler. By default, if LLVM detects a fatal error, it
 * will call exit(1). This may not be appropriate in many contexts. For example,
 * doing exit(1) will bypass many crash reporting/tracing system tools. This
 * function allows you to install a callback that will be invoked prior to the
 * call to exit(1).
 */
public static native void LLVMInstallFatalErrorHandler(LLVMFatalErrorHandler Handler);

/**
 * Reset the fatal error handler. This resets LLVM's fatal error handling
 * behavior to the default.
 */
public static native void LLVMResetFatalErrorHandler();

/**
 * Enable LLVM's built-in stack trace code. This intercepts the OS's crash
 * signals and prints which component of LLVM you were in at the time if the
 * crash.
 */
public static native void LLVMEnablePrettyStackTrace();

/**
 * @defgroup LLVMCCoreContext Contexts
 *
 * Contexts are execution states for the core LLVM IR system.
 *
 * Most types are tied to a context instance. Multiple contexts can
 * exist simultaneously. A single context is not thread safe. However,
 * different contexts can execute on different threads simultaneously.
 *
 * @{
 */

public static class LLVMDiagnosticHandler extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMDiagnosticHandler(Pointer p) { super(p); }
    protected LLVMDiagnosticHandler() { allocate(); }
    private native void allocate();
    public native void call(LLVMDiagnosticInfoRef arg0, Pointer arg1);
}
public static class LLVMYieldCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMYieldCallback(Pointer p) { super(p); }
    protected LLVMYieldCallback() { allocate(); }
    private native void allocate();
    public native void call(LLVMContextRef arg0, Pointer arg1);
}

/**
 * Create a new context.
 *
 * Every call to this function should be paired with a call to
 * LLVMContextDispose() or the context will leak memory.
 */
public static native LLVMContextRef LLVMContextCreate();

/**
 * Obtain the global context instance.
 */
public static native LLVMContextRef LLVMGetGlobalContext();

/**
 * Set the diagnostic handler for this context.
 */
public static native void LLVMContextSetDiagnosticHandler(LLVMContextRef C,
                                     LLVMDiagnosticHandler Handler,
                                     Pointer DiagnosticContext);

/**
 * Set the yield callback function for this context.
 *
 * @see LLVMContext::setYieldCallback()
 */
public static native void LLVMContextSetYieldCallback(LLVMContextRef C, LLVMYieldCallback Callback,
                                 Pointer OpaqueHandle);

/**
 * Destroy a context instance.
 *
 * This should be called for every call to LLVMContextCreate() or memory
 * will be leaked.
 */
public static native void LLVMContextDispose(LLVMContextRef C);

/**
 * Return a string representation of the DiagnosticInfo. Use
 * LLVMDisposeMessage to free the string.
 *
 * @see DiagnosticInfo::print()
 */
public static native @Cast("char*") BytePointer LLVMGetDiagInfoDescription(LLVMDiagnosticInfoRef DI);

/**
 * Return an enum LLVMDiagnosticSeverity.
 *
 * @see DiagnosticInfo::getSeverity()
 */
public static native @Cast("LLVMDiagnosticSeverity") int LLVMGetDiagInfoSeverity(LLVMDiagnosticInfoRef DI);

public static native @Cast("unsigned") int LLVMGetMDKindIDInContext(LLVMContextRef C, @Cast("const char*") BytePointer Name,
                                  @Cast("unsigned") int SLen);
public static native @Cast("unsigned") int LLVMGetMDKindIDInContext(LLVMContextRef C, String Name,
                                  @Cast("unsigned") int SLen);
public static native @Cast("unsigned") int LLVMGetMDKindID(@Cast("const char*") BytePointer Name, @Cast("unsigned") int SLen);
public static native @Cast("unsigned") int LLVMGetMDKindID(String Name, @Cast("unsigned") int SLen);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreModule Modules
 *
 * Modules represent the top-level structure in an LLVM program. An LLVM
 * module is effectively a translation unit or a collection of
 * translation units merged together.
 *
 * @{
 */

/**
 * Create a new, empty module in the global context.
 *
 * This is equivalent to calling LLVMModuleCreateWithNameInContext with
 * LLVMGetGlobalContext() as the context parameter.
 *
 * Every invocation should be paired with LLVMDisposeModule() or memory
 * will be leaked.
 */
public static native LLVMModuleRef LLVMModuleCreateWithName(@Cast("const char*") BytePointer ModuleID);
public static native LLVMModuleRef LLVMModuleCreateWithName(String ModuleID);

/**
 * Create a new, empty module in a specific context.
 *
 * Every invocation should be paired with LLVMDisposeModule() or memory
 * will be leaked.
 */
public static native LLVMModuleRef LLVMModuleCreateWithNameInContext(@Cast("const char*") BytePointer ModuleID,
                                                LLVMContextRef C);
public static native LLVMModuleRef LLVMModuleCreateWithNameInContext(String ModuleID,
                                                LLVMContextRef C);
/**
 * Return an exact copy of the specified module.
 */
public static native LLVMModuleRef LLVMCloneModule(LLVMModuleRef M);

/**
 * Destroy a module instance.
 *
 * This must be called for every created module or memory will be
 * leaked.
 */
public static native void LLVMDisposeModule(LLVMModuleRef M);

/**
 * Obtain the data layout for a module.
 *
 * @see Module::getDataLayout()
 */
public static native @Cast("const char*") BytePointer LLVMGetDataLayout(LLVMModuleRef M);

/**
 * Set the data layout for a module.
 *
 * @see Module::setDataLayout()
 */
public static native void LLVMSetDataLayout(LLVMModuleRef M, @Cast("const char*") BytePointer Triple);
public static native void LLVMSetDataLayout(LLVMModuleRef M, String Triple);

/**
 * Obtain the target triple for a module.
 *
 * @see Module::getTargetTriple()
 */
public static native @Cast("const char*") BytePointer LLVMGetTarget(LLVMModuleRef M);

/**
 * Set the target triple for a module.
 *
 * @see Module::setTargetTriple()
 */
public static native void LLVMSetTarget(LLVMModuleRef M, @Cast("const char*") BytePointer Triple);
public static native void LLVMSetTarget(LLVMModuleRef M, String Triple);

/**
 * Dump a representation of a module to stderr.
 *
 * @see Module::dump()
 */
public static native void LLVMDumpModule(LLVMModuleRef M);

/**
 * Print a representation of a module to a file. The ErrorMessage needs to be
 * disposed with LLVMDisposeMessage. Returns 0 on success, 1 otherwise.
 *
 * @see Module::print()
 */
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, @Cast("const char*") BytePointer Filename,
                               @Cast("char**") PointerPointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, @Cast("const char*") BytePointer Filename,
                               @Cast("char**") @ByPtrPtr BytePointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, String Filename,
                               @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, @Cast("const char*") BytePointer Filename,
                               @Cast("char**") @ByPtrPtr byte[] ErrorMessage);
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, String Filename,
                               @Cast("char**") @ByPtrPtr BytePointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, @Cast("const char*") BytePointer Filename,
                               @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMPrintModuleToFile(LLVMModuleRef M, String Filename,
                               @Cast("char**") @ByPtrPtr byte[] ErrorMessage);

/**
 * Return a string representation of the module. Use
 * LLVMDisposeMessage to free the string.
 *
 * @see Module::print()
 */
public static native @Cast("char*") BytePointer LLVMPrintModuleToString(LLVMModuleRef M);

/**
 * Set inline assembly for a module.
 *
 * @see Module::setModuleInlineAsm()
 */
public static native void LLVMSetModuleInlineAsm(LLVMModuleRef M, @Cast("const char*") BytePointer Asm);
public static native void LLVMSetModuleInlineAsm(LLVMModuleRef M, String Asm);

/**
 * Obtain the context to which this module is associated.
 *
 * @see Module::getContext()
 */
public static native LLVMContextRef LLVMGetModuleContext(LLVMModuleRef M);

/**
 * Obtain a Type from a module by its registered name.
 */
public static native LLVMTypeRef LLVMGetTypeByName(LLVMModuleRef M, @Cast("const char*") BytePointer Name);
public static native LLVMTypeRef LLVMGetTypeByName(LLVMModuleRef M, String Name);

/**
 * Obtain the number of operands for named metadata in a module.
 *
 * @see llvm::Module::getNamedMetadata()
 */
public static native @Cast("unsigned") int LLVMGetNamedMetadataNumOperands(LLVMModuleRef M, @Cast("const char*") BytePointer name);
public static native @Cast("unsigned") int LLVMGetNamedMetadataNumOperands(LLVMModuleRef M, String name);

/**
 * Obtain the named metadata operands for a module.
 *
 * The passed LLVMValueRef pointer should refer to an array of
 * LLVMValueRef at least LLVMGetNamedMetadataNumOperands long. This
 * array will be populated with the LLVMValueRef instances. Each
 * instance corresponds to a llvm::MDNode.
 *
 * @see llvm::Module::getNamedMetadata()
 * @see llvm::MDNode::getOperand()
 */
public static native void LLVMGetNamedMetadataOperands(LLVMModuleRef M, @Cast("const char*") BytePointer name, @ByPtrPtr LLVMValueRef Dest);
public static native void LLVMGetNamedMetadataOperands(LLVMModuleRef M, String name, @Cast("LLVMValueRef*") PointerPointer Dest);

/**
 * Add an operand to named metadata.
 *
 * @see llvm::Module::getNamedMetadata()
 * @see llvm::MDNode::addOperand()
 */
public static native void LLVMAddNamedMetadataOperand(LLVMModuleRef M, @Cast("const char*") BytePointer name,
                                 LLVMValueRef Val);
public static native void LLVMAddNamedMetadataOperand(LLVMModuleRef M, String name,
                                 LLVMValueRef Val);

/**
 * Add a function to a module under a specified name.
 *
 * @see llvm::Function::Create()
 */
public static native LLVMValueRef LLVMAddFunction(LLVMModuleRef M, @Cast("const char*") BytePointer Name,
                             LLVMTypeRef FunctionTy);
public static native LLVMValueRef LLVMAddFunction(LLVMModuleRef M, String Name,
                             LLVMTypeRef FunctionTy);

/**
 * Obtain a Function value from a Module by its name.
 *
 * The returned value corresponds to a llvm::Function value.
 *
 * @see llvm::Module::getFunction()
 */
public static native LLVMValueRef LLVMGetNamedFunction(LLVMModuleRef M, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMGetNamedFunction(LLVMModuleRef M, String Name);

/**
 * Obtain an iterator to the first Function in a Module.
 *
 * @see llvm::Module::begin()
 */
public static native LLVMValueRef LLVMGetFirstFunction(LLVMModuleRef M);

/**
 * Obtain an iterator to the last Function in a Module.
 *
 * @see llvm::Module::end()
 */
public static native LLVMValueRef LLVMGetLastFunction(LLVMModuleRef M);

/**
 * Advance a Function iterator to the next Function.
 *
 * Returns NULL if the iterator was already at the end and there are no more
 * functions.
 */
public static native LLVMValueRef LLVMGetNextFunction(LLVMValueRef Fn);

/**
 * Decrement a Function iterator to the previous Function.
 *
 * Returns NULL if the iterator was already at the beginning and there are
 * no previous functions.
 */
public static native LLVMValueRef LLVMGetPreviousFunction(LLVMValueRef Fn);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreType Types
 *
 * Types represent the type of a value.
 *
 * Types are associated with a context instance. The context internally
 * deduplicates types so there is only 1 instance of a specific type
 * alive at a time. In other words, a unique type is shared among all
 * consumers within a context.
 *
 * A Type in the C API corresponds to llvm::Type.
 *
 * Types have the following hierarchy:
 *
 *   types:
 *     integer type
 *     real type
 *     function type
 *     sequence types:
 *       array type
 *       pointer type
 *       vector type
 *     void type
 *     label type
 *     opaque type
 *
 * @{
 */

/**
 * Obtain the enumerated type of a Type instance.
 *
 * @see llvm::Type:getTypeID()
 */
public static native @Cast("LLVMTypeKind") int LLVMGetTypeKind(LLVMTypeRef Ty);

/**
 * Whether the type has a known size.
 *
 * Things that don't have a size are abstract types, labels, and void.a
 *
 * @see llvm::Type::isSized()
 */
public static native @Cast("LLVMBool") int LLVMTypeIsSized(LLVMTypeRef Ty);

/**
 * Obtain the context to which this type instance is associated.
 *
 * @see llvm::Type::getContext()
 */
public static native LLVMContextRef LLVMGetTypeContext(LLVMTypeRef Ty);

/**
 * Dump a representation of a type to stderr.
 *
 * @see llvm::Type::dump()
 */
public static native void LLVMDumpType(LLVMTypeRef Val);

/**
 * Return a string representation of the type. Use
 * LLVMDisposeMessage to free the string.
 *
 * @see llvm::Type::print()
 */
public static native @Cast("char*") BytePointer LLVMPrintTypeToString(LLVMTypeRef Val);

/**
 * @defgroup LLVMCCoreTypeInt Integer Types
 *
 * Functions in this section operate on integer types.
 *
 * @{
 */

/**
 * Obtain an integer type from a context with specified bit width.
 */
public static native LLVMTypeRef LLVMInt1TypeInContext(LLVMContextRef C);
public static native LLVMTypeRef LLVMInt8TypeInContext(LLVMContextRef C);
public static native LLVMTypeRef LLVMInt16TypeInContext(LLVMContextRef C);
public static native LLVMTypeRef LLVMInt32TypeInContext(LLVMContextRef C);
public static native LLVMTypeRef LLVMInt64TypeInContext(LLVMContextRef C);
public static native LLVMTypeRef LLVMIntTypeInContext(LLVMContextRef C, @Cast("unsigned") int NumBits);

/**
 * Obtain an integer type from the global context with a specified bit
 * width.
 */
public static native LLVMTypeRef LLVMInt1Type();
public static native LLVMTypeRef LLVMInt8Type();
public static native LLVMTypeRef LLVMInt16Type();
public static native LLVMTypeRef LLVMInt32Type();
public static native LLVMTypeRef LLVMInt64Type();
public static native LLVMTypeRef LLVMIntType(@Cast("unsigned") int NumBits);
public static native @Cast("unsigned") int LLVMGetIntTypeWidth(LLVMTypeRef IntegerTy);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreTypeFloat Floating Point Types
 *
 * @{
 */

/**
 * Obtain a 16-bit floating point type from a context.
 */
public static native LLVMTypeRef LLVMHalfTypeInContext(LLVMContextRef C);

/**
 * Obtain a 32-bit floating point type from a context.
 */
public static native LLVMTypeRef LLVMFloatTypeInContext(LLVMContextRef C);

/**
 * Obtain a 64-bit floating point type from a context.
 */
public static native LLVMTypeRef LLVMDoubleTypeInContext(LLVMContextRef C);

/**
 * Obtain a 80-bit floating point type (X87) from a context.
 */
public static native LLVMTypeRef LLVMX86FP80TypeInContext(LLVMContextRef C);

/**
 * Obtain a 128-bit floating point type (112-bit mantissa) from a
 * context.
 */
public static native LLVMTypeRef LLVMFP128TypeInContext(LLVMContextRef C);

/**
 * Obtain a 128-bit floating point type (two 64-bits) from a context.
 */
public static native LLVMTypeRef LLVMPPCFP128TypeInContext(LLVMContextRef C);

/**
 * Obtain a floating point type from the global context.
 *
 * These map to the functions in this group of the same name.
 */
public static native LLVMTypeRef LLVMHalfType();
public static native LLVMTypeRef LLVMFloatType();
public static native LLVMTypeRef LLVMDoubleType();
public static native LLVMTypeRef LLVMX86FP80Type();
public static native LLVMTypeRef LLVMFP128Type();
public static native LLVMTypeRef LLVMPPCFP128Type();

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreTypeFunction Function Types
 *
 * @{
 */

/**
 * Obtain a function type consisting of a specified signature.
 *
 * The function is defined as a tuple of a return Type, a list of
 * parameter types, and whether the function is variadic.
 */
public static native LLVMTypeRef LLVMFunctionType(LLVMTypeRef ReturnType,
                             @ByPtrPtr LLVMTypeRef ParamTypes, @Cast("unsigned") int ParamCount,
                             @Cast("LLVMBool") int IsVarArg);
public static native LLVMTypeRef LLVMFunctionType(LLVMTypeRef ReturnType,
                             @Cast("LLVMTypeRef*") PointerPointer ParamTypes, @Cast("unsigned") int ParamCount,
                             @Cast("LLVMBool") int IsVarArg);

/**
 * Returns whether a function type is variadic.
 */
public static native @Cast("LLVMBool") int LLVMIsFunctionVarArg(LLVMTypeRef FunctionTy);

/**
 * Obtain the Type this function Type returns.
 */
public static native LLVMTypeRef LLVMGetReturnType(LLVMTypeRef FunctionTy);

/**
 * Obtain the number of parameters this function accepts.
 */
public static native @Cast("unsigned") int LLVMCountParamTypes(LLVMTypeRef FunctionTy);

/**
 * Obtain the types of a function's parameters.
 *
 * The Dest parameter should point to a pre-allocated array of
 * LLVMTypeRef at least LLVMCountParamTypes() large. On return, the
 * first LLVMCountParamTypes() entries in the array will be populated
 * with LLVMTypeRef instances.
 *
 * @param FunctionTy The function type to operate on.
 * @param Dest Memory address of an array to be filled with result.
 */
public static native void LLVMGetParamTypes(LLVMTypeRef FunctionTy, @ByPtrPtr LLVMTypeRef Dest);
public static native void LLVMGetParamTypes(LLVMTypeRef FunctionTy, @Cast("LLVMTypeRef*") PointerPointer Dest);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreTypeStruct Structure Types
 *
 * These functions relate to LLVMTypeRef instances.
 *
 * @see llvm::StructType
 *
 * @{
 */

/**
 * Create a new structure type in a context.
 *
 * A structure is specified by a list of inner elements/types and
 * whether these can be packed together.
 *
 * @see llvm::StructType::create()
 */
public static native LLVMTypeRef LLVMStructTypeInContext(LLVMContextRef C, @ByPtrPtr LLVMTypeRef ElementTypes,
                                    @Cast("unsigned") int ElementCount, @Cast("LLVMBool") int Packed);
public static native LLVMTypeRef LLVMStructTypeInContext(LLVMContextRef C, @Cast("LLVMTypeRef*") PointerPointer ElementTypes,
                                    @Cast("unsigned") int ElementCount, @Cast("LLVMBool") int Packed);

/**
 * Create a new structure type in the global context.
 *
 * @see llvm::StructType::create()
 */
public static native LLVMTypeRef LLVMStructType(@ByPtrPtr LLVMTypeRef ElementTypes, @Cast("unsigned") int ElementCount,
                           @Cast("LLVMBool") int Packed);
public static native LLVMTypeRef LLVMStructType(@Cast("LLVMTypeRef*") PointerPointer ElementTypes, @Cast("unsigned") int ElementCount,
                           @Cast("LLVMBool") int Packed);

/**
 * Create an empty structure in a context having a specified name.
 *
 * @see llvm::StructType::create()
 */
public static native LLVMTypeRef LLVMStructCreateNamed(LLVMContextRef C, @Cast("const char*") BytePointer Name);
public static native LLVMTypeRef LLVMStructCreateNamed(LLVMContextRef C, String Name);

/**
 * Obtain the name of a structure.
 *
 * @see llvm::StructType::getName()
 */
public static native @Cast("const char*") BytePointer LLVMGetStructName(LLVMTypeRef Ty);

/**
 * Set the contents of a structure type.
 *
 * @see llvm::StructType::setBody()
 */
public static native void LLVMStructSetBody(LLVMTypeRef StructTy, @ByPtrPtr LLVMTypeRef ElementTypes,
                       @Cast("unsigned") int ElementCount, @Cast("LLVMBool") int Packed);
public static native void LLVMStructSetBody(LLVMTypeRef StructTy, @Cast("LLVMTypeRef*") PointerPointer ElementTypes,
                       @Cast("unsigned") int ElementCount, @Cast("LLVMBool") int Packed);

/**
 * Get the number of elements defined inside the structure.
 *
 * @see llvm::StructType::getNumElements()
 */
public static native @Cast("unsigned") int LLVMCountStructElementTypes(LLVMTypeRef StructTy);

/**
 * Get the elements within a structure.
 *
 * The function is passed the address of a pre-allocated array of
 * LLVMTypeRef at least LLVMCountStructElementTypes() long. After
 * invocation, this array will be populated with the structure's
 * elements. The objects in the destination array will have a lifetime
 * of the structure type itself, which is the lifetime of the context it
 * is contained in.
 */
public static native void LLVMGetStructElementTypes(LLVMTypeRef StructTy, @ByPtrPtr LLVMTypeRef Dest);
public static native void LLVMGetStructElementTypes(LLVMTypeRef StructTy, @Cast("LLVMTypeRef*") PointerPointer Dest);

/**
 * Get the type of the element at a given index in the structure.
 *
 * @see llvm::StructType::getTypeAtIndex()
 */
public static native LLVMTypeRef LLVMStructGetTypeAtIndex(LLVMTypeRef StructTy, @Cast("unsigned") int i);

/**
 * Determine whether a structure is packed.
 *
 * @see llvm::StructType::isPacked()
 */
public static native @Cast("LLVMBool") int LLVMIsPackedStruct(LLVMTypeRef StructTy);

/**
 * Determine whether a structure is opaque.
 *
 * @see llvm::StructType::isOpaque()
 */
public static native @Cast("LLVMBool") int LLVMIsOpaqueStruct(LLVMTypeRef StructTy);

/**
 * @}
 */


/**
 * @defgroup LLVMCCoreTypeSequential Sequential Types
 *
 * Sequential types represents "arrays" of types. This is a super class
 * for array, vector, and pointer types.
 *
 * @{
 */

/**
 * Obtain the type of elements within a sequential type.
 *
 * This works on array, vector, and pointer types.
 *
 * @see llvm::SequentialType::getElementType()
 */
public static native LLVMTypeRef LLVMGetElementType(LLVMTypeRef Ty);

/**
 * Create a fixed size array type that refers to a specific type.
 *
 * The created type will exist in the context that its element type
 * exists in.
 *
 * @see llvm::ArrayType::get()
 */
public static native LLVMTypeRef LLVMArrayType(LLVMTypeRef ElementType, @Cast("unsigned") int ElementCount);

/**
 * Obtain the length of an array type.
 *
 * This only works on types that represent arrays.
 *
 * @see llvm::ArrayType::getNumElements()
 */
public static native @Cast("unsigned") int LLVMGetArrayLength(LLVMTypeRef ArrayTy);

/**
 * Create a pointer type that points to a defined type.
 *
 * The created type will exist in the context that its pointee type
 * exists in.
 *
 * @see llvm::PointerType::get()
 */
public static native LLVMTypeRef LLVMPointerType(LLVMTypeRef ElementType, @Cast("unsigned") int AddressSpace);

/**
 * Obtain the address space of a pointer type.
 *
 * This only works on types that represent pointers.
 *
 * @see llvm::PointerType::getAddressSpace()
 */
public static native @Cast("unsigned") int LLVMGetPointerAddressSpace(LLVMTypeRef PointerTy);

/**
 * Create a vector type that contains a defined type and has a specific
 * number of elements.
 *
 * The created type will exist in the context thats its element type
 * exists in.
 *
 * @see llvm::VectorType::get()
 */
public static native LLVMTypeRef LLVMVectorType(LLVMTypeRef ElementType, @Cast("unsigned") int ElementCount);

/**
 * Obtain the number of elements in a vector type.
 *
 * This only works on types that represent vectors.
 *
 * @see llvm::VectorType::getNumElements()
 */
public static native @Cast("unsigned") int LLVMGetVectorSize(LLVMTypeRef VectorTy);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreTypeOther Other Types
 *
 * @{
 */

/**
 * Create a void type in a context.
 */
public static native LLVMTypeRef LLVMVoidTypeInContext(LLVMContextRef C);

/**
 * Create a label type in a context.
 */
public static native LLVMTypeRef LLVMLabelTypeInContext(LLVMContextRef C);

/**
 * Create a X86 MMX type in a context.
 */
public static native LLVMTypeRef LLVMX86MMXTypeInContext(LLVMContextRef C);

/**
 * These are similar to the above functions except they operate on the
 * global context.
 */
public static native LLVMTypeRef LLVMVoidType();
public static native LLVMTypeRef LLVMLabelType();
public static native LLVMTypeRef LLVMX86MMXType();

/**
 * @}
 */

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValues Values
 *
 * The bulk of LLVM's object model consists of values, which comprise a very
 * rich type hierarchy.
 *
 * LLVMValueRef essentially represents llvm::Value. There is a rich
 * hierarchy of classes within this type. Depending on the instance
 * obtained, not all APIs are available.
 *
 * Callers can determine the type of an LLVMValueRef by calling the
 * LLVMIsA* family of functions (e.g. LLVMIsAArgument()). These
 * functions are defined by a macro, so it isn't obvious which are
 * available by looking at the Doxygen source code. Instead, look at the
 * source definition of LLVM_FOR_EACH_VALUE_SUBCLASS and note the list
 * of value names given. These value names also correspond to classes in
 * the llvm::Value hierarchy.
 *
 * @{
 */

// #define LLVM_FOR_EACH_VALUE_SUBCLASS(macro)
//   macro(Argument)
//   macro(BasicBlock)
//   macro(InlineAsm)
//   macro(User)
//     macro(Constant)
//       macro(BlockAddress)
//       macro(ConstantAggregateZero)
//       macro(ConstantArray)
//       macro(ConstantDataSequential)
//         macro(ConstantDataArray)
//         macro(ConstantDataVector)
//       macro(ConstantExpr)
//       macro(ConstantFP)
//       macro(ConstantInt)
//       macro(ConstantPointerNull)
//       macro(ConstantStruct)
//       macro(ConstantVector)
//       macro(GlobalValue)
//         macro(GlobalAlias)
//         macro(GlobalObject)
//           macro(Function)
//           macro(GlobalVariable)
//       macro(UndefValue)
//     macro(Instruction)
//       macro(BinaryOperator)
//       macro(CallInst)
//         macro(IntrinsicInst)
//           macro(DbgInfoIntrinsic)
//             macro(DbgDeclareInst)
//           macro(MemIntrinsic)
//             macro(MemCpyInst)
//             macro(MemMoveInst)
//             macro(MemSetInst)
//       macro(CmpInst)
//         macro(FCmpInst)
//         macro(ICmpInst)
//       macro(ExtractElementInst)
//       macro(GetElementPtrInst)
//       macro(InsertElementInst)
//       macro(InsertValueInst)
//       macro(LandingPadInst)
//       macro(PHINode)
//       macro(SelectInst)
//       macro(ShuffleVectorInst)
//       macro(StoreInst)
//       macro(TerminatorInst)
//         macro(BranchInst)
//         macro(IndirectBrInst)
//         macro(InvokeInst)
//         macro(ReturnInst)
//         macro(SwitchInst)
//         macro(UnreachableInst)
//         macro(ResumeInst)
//       macro(UnaryInstruction)
//         macro(AllocaInst)
//         macro(CastInst)
//           macro(AddrSpaceCastInst)
//           macro(BitCastInst)
//           macro(FPExtInst)
//           macro(FPToSIInst)
//           macro(FPToUIInst)
//           macro(FPTruncInst)
//           macro(IntToPtrInst)
//           macro(PtrToIntInst)
//           macro(SExtInst)
//           macro(SIToFPInst)
//           macro(TruncInst)
//           macro(UIToFPInst)
//           macro(ZExtInst)
//         macro(ExtractValueInst)
//         macro(LoadInst)
//         macro(VAArgInst)

/**
 * @defgroup LLVMCCoreValueGeneral General APIs
 *
 * Functions in this section work on all LLVMValueRef instances,
 * regardless of their sub-type. They correspond to functions available
 * on llvm::Value.
 *
 * @{
 */

/**
 * Obtain the type of a value.
 *
 * @see llvm::Value::getType()
 */
public static native LLVMTypeRef LLVMTypeOf(LLVMValueRef Val);

/**
 * Obtain the string name of a value.
 *
 * @see llvm::Value::getName()
 */
public static native @Cast("const char*") BytePointer LLVMGetValueName(LLVMValueRef Val);

/**
 * Set the string name of a value.
 *
 * @see llvm::Value::setName()
 */
public static native void LLVMSetValueName(LLVMValueRef Val, @Cast("const char*") BytePointer Name);
public static native void LLVMSetValueName(LLVMValueRef Val, String Name);

/**
 * Dump a representation of a value to stderr.
 *
 * @see llvm::Value::dump()
 */
public static native void LLVMDumpValue(LLVMValueRef Val);

/**
 * Return a string representation of the value. Use
 * LLVMDisposeMessage to free the string.
 *
 * @see llvm::Value::print()
 */
public static native @Cast("char*") BytePointer LLVMPrintValueToString(LLVMValueRef Val);

/**
 * Replace all uses of a value with another one.
 *
 * @see llvm::Value::replaceAllUsesWith()
 */
public static native void LLVMReplaceAllUsesWith(LLVMValueRef OldVal, LLVMValueRef NewVal);

/**
 * Determine whether the specified constant instance is constant.
 */
public static native @Cast("LLVMBool") int LLVMIsConstant(LLVMValueRef Val);

/**
 * Determine whether a value instance is undefined.
 */
public static native @Cast("LLVMBool") int LLVMIsUndef(LLVMValueRef Val);

/**
 * Convert value instances between types.
 *
 * Internally, an LLVMValueRef is "pinned" to a specific type. This
 * series of functions allows you to cast an instance to a specific
 * type.
 *
 * If the cast is not valid for the specified type, NULL is returned.
 *
 * @see llvm::dyn_cast_or_null<>
 */
// #define LLVM_DECLARE_VALUE_CAST(name)
//   LLVMValueRef LLVMIsA##name(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAArgument(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsABasicBlock(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAInlineAsm(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAUser(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstant(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsABlockAddress(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantAggregateZero(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantArray(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantDataSequential(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantDataArray(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantDataVector(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantExpr(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantFP(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantInt(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantPointerNull(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantStruct(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAConstantVector(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAGlobalValue(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAGlobalAlias(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAGlobalObject(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAFunction(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAGlobalVariable(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAUndefValue(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAInstruction(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsABinaryOperator(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsACallInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAIntrinsicInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsADbgInfoIntrinsic(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsADbgDeclareInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAMemIntrinsic(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAMemCpyInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAMemMoveInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAMemSetInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsACmpInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAFCmpInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAICmpInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAExtractElementInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAGetElementPtrInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAInsertElementInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAInsertValueInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsALandingPadInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAPHINode(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsASelectInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAShuffleVectorInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAStoreInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsATerminatorInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsABranchInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAIndirectBrInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAInvokeInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAReturnInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsASwitchInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAUnreachableInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAResumeInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAUnaryInstruction(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAAllocaInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsACastInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAAddrSpaceCastInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsABitCastInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAFPExtInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAFPToSIInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAFPToUIInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAFPTruncInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAIntToPtrInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAPtrToIntInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsASExtInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsASIToFPInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsATruncInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAUIToFPInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAZExtInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAExtractValueInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsALoadInst(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAVAArgInst(LLVMValueRef Val);

public static native LLVMValueRef LLVMIsAMDNode(LLVMValueRef Val);
public static native LLVMValueRef LLVMIsAMDString(LLVMValueRef Val);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueUses Usage
 *
 * This module defines functions that allow you to inspect the uses of a
 * LLVMValueRef.
 *
 * It is possible to obtain an LLVMUseRef for any LLVMValueRef instance.
 * Each LLVMUseRef (which corresponds to a llvm::Use instance) holds a
 * llvm::User and llvm::Value.
 *
 * @{
 */

/**
 * Obtain the first use of a value.
 *
 * Uses are obtained in an iterator fashion. First, call this function
 * to obtain a reference to the first use. Then, call LLVMGetNextUse()
 * on that instance and all subsequently obtained instances until
 * LLVMGetNextUse() returns NULL.
 *
 * @see llvm::Value::use_begin()
 */
public static native LLVMUseRef LLVMGetFirstUse(LLVMValueRef Val);

/**
 * Obtain the next use of a value.
 *
 * This effectively advances the iterator. It returns NULL if you are on
 * the final use and no more are available.
 */
public static native LLVMUseRef LLVMGetNextUse(LLVMUseRef U);

/**
 * Obtain the user value for a user.
 *
 * The returned value corresponds to a llvm::User type.
 *
 * @see llvm::Use::getUser()
 */
public static native LLVMValueRef LLVMGetUser(LLVMUseRef U);

/**
 * Obtain the value this use corresponds to.
 *
 * @see llvm::Use::get().
 */
public static native LLVMValueRef LLVMGetUsedValue(LLVMUseRef U);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueUser User value
 *
 * Function in this group pertain to LLVMValueRef instances that descent
 * from llvm::User. This includes constants, instructions, and
 * operators.
 *
 * @{
 */

/**
 * Obtain an operand at a specific index in a llvm::User value.
 *
 * @see llvm::User::getOperand()
 */
public static native LLVMValueRef LLVMGetOperand(LLVMValueRef Val, @Cast("unsigned") int Index);

/**
 * Obtain the use of an operand at a specific index in a llvm::User value.
 *
 * @see llvm::User::getOperandUse()
 */
public static native LLVMUseRef LLVMGetOperandUse(LLVMValueRef Val, @Cast("unsigned") int Index);

/**
 * Set an operand at a specific index in a llvm::User value.
 *
 * @see llvm::User::setOperand()
 */
public static native void LLVMSetOperand(LLVMValueRef User, @Cast("unsigned") int Index, LLVMValueRef Val);

/**
 * Obtain the number of operands in a llvm::User value.
 *
 * @see llvm::User::getNumOperands()
 */
public static native int LLVMGetNumOperands(LLVMValueRef Val);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueConstant Constants
 *
 * This section contains APIs for interacting with LLVMValueRef that
 * correspond to llvm::Constant instances.
 *
 * These functions will work for any LLVMValueRef in the llvm::Constant
 * class hierarchy.
 *
 * @{
 */

/**
 * Obtain a constant value referring to the null instance of a type.
 *
 * @see llvm::Constant::getNullValue()
 */
public static native LLVMValueRef LLVMConstNull(LLVMTypeRef Ty); /* all zeroes */

/**
 * Obtain a constant value referring to the instance of a type
 * consisting of all ones.
 *
 * This is only valid for integer types.
 *
 * @see llvm::Constant::getAllOnesValue()
 */
public static native LLVMValueRef LLVMConstAllOnes(LLVMTypeRef Ty);

/**
 * Obtain a constant value referring to an undefined value of a type.
 *
 * @see llvm::UndefValue::get()
 */
public static native LLVMValueRef LLVMGetUndef(LLVMTypeRef Ty);

/**
 * Determine whether a value instance is null.
 *
 * @see llvm::Constant::isNullValue()
 */
public static native @Cast("LLVMBool") int LLVMIsNull(LLVMValueRef Val);

/**
 * Obtain a constant that is a constant pointer pointing to NULL for a
 * specified type.
 */
public static native LLVMValueRef LLVMConstPointerNull(LLVMTypeRef Ty);

/**
 * @defgroup LLVMCCoreValueConstantScalar Scalar constants
 *
 * Functions in this group model LLVMValueRef instances that correspond
 * to constants referring to scalar types.
 *
 * For integer types, the LLVMTypeRef parameter should correspond to a
 * llvm::IntegerType instance and the returned LLVMValueRef will
 * correspond to a llvm::ConstantInt.
 *
 * For floating point types, the LLVMTypeRef returned corresponds to a
 * llvm::ConstantFP.
 *
 * @{
 */

/**
 * Obtain a constant value for an integer type.
 *
 * The returned value corresponds to a llvm::ConstantInt.
 *
 * @see llvm::ConstantInt::get()
 *
 * @param IntTy Integer type to obtain value of.
 * @param N The value the returned instance should refer to.
 * @param SignExtend Whether to sign extend the produced value.
 */
public static native LLVMValueRef LLVMConstInt(LLVMTypeRef IntTy, @Cast("unsigned long long") long N,
                          @Cast("LLVMBool") int SignExtend);

/**
 * Obtain a constant value for an integer of arbitrary precision.
 *
 * @see llvm::ConstantInt::get()
 */
public static native LLVMValueRef LLVMConstIntOfArbitraryPrecision(LLVMTypeRef IntTy,
                                              @Cast("unsigned") int NumWords,
                                              @Cast("const uint64_t*") LongPointer Words);
public static native LLVMValueRef LLVMConstIntOfArbitraryPrecision(LLVMTypeRef IntTy,
                                              @Cast("unsigned") int NumWords,
                                              @Cast("const uint64_t*") LongBuffer Words);
public static native LLVMValueRef LLVMConstIntOfArbitraryPrecision(LLVMTypeRef IntTy,
                                              @Cast("unsigned") int NumWords,
                                              @Cast("const uint64_t*") long[] Words);

/**
 * Obtain a constant value for an integer parsed from a string.
 *
 * A similar API, LLVMConstIntOfStringAndSize is also available. If the
 * string's length is available, it is preferred to call that function
 * instead.
 *
 * @see llvm::ConstantInt::get()
 */
public static native LLVMValueRef LLVMConstIntOfString(LLVMTypeRef IntTy, @Cast("const char*") BytePointer Text,
                                  @Cast("uint8_t") byte Radix);
public static native LLVMValueRef LLVMConstIntOfString(LLVMTypeRef IntTy, String Text,
                                  @Cast("uint8_t") byte Radix);

/**
 * Obtain a constant value for an integer parsed from a string with
 * specified length.
 *
 * @see llvm::ConstantInt::get()
 */
public static native LLVMValueRef LLVMConstIntOfStringAndSize(LLVMTypeRef IntTy, @Cast("const char*") BytePointer Text,
                                         @Cast("unsigned") int SLen, @Cast("uint8_t") byte Radix);
public static native LLVMValueRef LLVMConstIntOfStringAndSize(LLVMTypeRef IntTy, String Text,
                                         @Cast("unsigned") int SLen, @Cast("uint8_t") byte Radix);

/**
 * Obtain a constant value referring to a double floating point value.
 */
public static native LLVMValueRef LLVMConstReal(LLVMTypeRef RealTy, double N);

/**
 * Obtain a constant for a floating point value parsed from a string.
 *
 * A similar API, LLVMConstRealOfStringAndSize is also available. It
 * should be used if the input string's length is known.
 */
public static native LLVMValueRef LLVMConstRealOfString(LLVMTypeRef RealTy, @Cast("const char*") BytePointer Text);
public static native LLVMValueRef LLVMConstRealOfString(LLVMTypeRef RealTy, String Text);

/**
 * Obtain a constant for a floating point value parsed from a string.
 */
public static native LLVMValueRef LLVMConstRealOfStringAndSize(LLVMTypeRef RealTy, @Cast("const char*") BytePointer Text,
                                          @Cast("unsigned") int SLen);
public static native LLVMValueRef LLVMConstRealOfStringAndSize(LLVMTypeRef RealTy, String Text,
                                          @Cast("unsigned") int SLen);

/**
 * Obtain the zero extended value for an integer constant value.
 *
 * @see llvm::ConstantInt::getZExtValue()
 */
public static native @Cast("unsigned long long") long LLVMConstIntGetZExtValue(LLVMValueRef ConstantVal);

/**
 * Obtain the sign extended value for an integer constant value.
 *
 * @see llvm::ConstantInt::getSExtValue()
 */
public static native long LLVMConstIntGetSExtValue(LLVMValueRef ConstantVal);

/**
 * Obtain the double value for an floating point constant value.
 * losesInfo indicates if some precision was lost in the conversion.
 *
 * @see llvm::ConstantFP::getDoubleValue
 */
public static native double LLVMConstRealGetDouble(LLVMValueRef ConstantVal, @Cast("LLVMBool*") IntPointer losesInfo);
public static native double LLVMConstRealGetDouble(LLVMValueRef ConstantVal, @Cast("LLVMBool*") IntBuffer losesInfo);
public static native double LLVMConstRealGetDouble(LLVMValueRef ConstantVal, @Cast("LLVMBool*") int[] losesInfo);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueConstantComposite Composite Constants
 *
 * Functions in this group operate on composite constants.
 *
 * @{
 */

/**
 * Create a ConstantDataSequential and initialize it with a string.
 *
 * @see llvm::ConstantDataArray::getString()
 */
public static native LLVMValueRef LLVMConstStringInContext(LLVMContextRef C, @Cast("const char*") BytePointer Str,
                                      @Cast("unsigned") int Length, @Cast("LLVMBool") int DontNullTerminate);
public static native LLVMValueRef LLVMConstStringInContext(LLVMContextRef C, String Str,
                                      @Cast("unsigned") int Length, @Cast("LLVMBool") int DontNullTerminate);

/**
 * Create a ConstantDataSequential with string content in the global context.
 *
 * This is the same as LLVMConstStringInContext except it operates on the
 * global context.
 *
 * @see LLVMConstStringInContext()
 * @see llvm::ConstantDataArray::getString()
 */
public static native LLVMValueRef LLVMConstString(@Cast("const char*") BytePointer Str, @Cast("unsigned") int Length,
                             @Cast("LLVMBool") int DontNullTerminate);
public static native LLVMValueRef LLVMConstString(String Str, @Cast("unsigned") int Length,
                             @Cast("LLVMBool") int DontNullTerminate);

/**
 * Returns true if the specified constant is an array of i8.
 *
 * @see ConstantDataSequential::getAsString()
 */
public static native @Cast("LLVMBool") int LLVMIsConstantString(LLVMValueRef c);

/**
 * Get the given constant data sequential as a string.
 *
 * @see ConstantDataSequential::getAsString()
 */
public static native @Cast("const char*") BytePointer LLVMGetAsString(LLVMValueRef c, @Cast("size_t*") SizeTPointer out);

/**
 * Create an anonymous ConstantStruct with the specified values.
 *
 * @see llvm::ConstantStruct::getAnon()
 */
public static native LLVMValueRef LLVMConstStructInContext(LLVMContextRef C,
                                      @ByPtrPtr LLVMValueRef ConstantVals,
                                      @Cast("unsigned") int Count, @Cast("LLVMBool") int Packed);
public static native LLVMValueRef LLVMConstStructInContext(LLVMContextRef C,
                                      @Cast("LLVMValueRef*") PointerPointer ConstantVals,
                                      @Cast("unsigned") int Count, @Cast("LLVMBool") int Packed);

/**
 * Create a ConstantStruct in the global Context.
 *
 * This is the same as LLVMConstStructInContext except it operates on the
 * global Context.
 *
 * @see LLVMConstStructInContext()
 */
public static native LLVMValueRef LLVMConstStruct(@ByPtrPtr LLVMValueRef ConstantVals, @Cast("unsigned") int Count,
                             @Cast("LLVMBool") int Packed);
public static native LLVMValueRef LLVMConstStruct(@Cast("LLVMValueRef*") PointerPointer ConstantVals, @Cast("unsigned") int Count,
                             @Cast("LLVMBool") int Packed);

/**
 * Create a ConstantArray from values.
 *
 * @see llvm::ConstantArray::get()
 */
public static native LLVMValueRef LLVMConstArray(LLVMTypeRef ElementTy,
                            @ByPtrPtr LLVMValueRef ConstantVals, @Cast("unsigned") int Length);
public static native LLVMValueRef LLVMConstArray(LLVMTypeRef ElementTy,
                            @Cast("LLVMValueRef*") PointerPointer ConstantVals, @Cast("unsigned") int Length);

/**
 * Create a non-anonymous ConstantStruct from values.
 *
 * @see llvm::ConstantStruct::get()
 */
public static native LLVMValueRef LLVMConstNamedStruct(LLVMTypeRef StructTy,
                                  @ByPtrPtr LLVMValueRef ConstantVals,
                                  @Cast("unsigned") int Count);
public static native LLVMValueRef LLVMConstNamedStruct(LLVMTypeRef StructTy,
                                  @Cast("LLVMValueRef*") PointerPointer ConstantVals,
                                  @Cast("unsigned") int Count);

/**
 * Get an element at specified index as a constant.
 *
 * @see ConstantDataSequential::getElementAsConstant()
 */
public static native LLVMValueRef LLVMGetElementAsConstant(LLVMValueRef c, @Cast("unsigned") int idx);

/**
 * Create a ConstantVector from values.
 *
 * @see llvm::ConstantVector::get()
 */
public static native LLVMValueRef LLVMConstVector(@ByPtrPtr LLVMValueRef ScalarConstantVals, @Cast("unsigned") int Size);
public static native LLVMValueRef LLVMConstVector(@Cast("LLVMValueRef*") PointerPointer ScalarConstantVals, @Cast("unsigned") int Size);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueConstantExpressions Constant Expressions
 *
 * Functions in this group correspond to APIs on llvm::ConstantExpr.
 *
 * @see llvm::ConstantExpr.
 *
 * @{
 */
public static native @Cast("LLVMOpcode") int LLVMGetConstOpcode(LLVMValueRef ConstantVal);
public static native LLVMValueRef LLVMAlignOf(LLVMTypeRef Ty);
public static native LLVMValueRef LLVMSizeOf(LLVMTypeRef Ty);
public static native LLVMValueRef LLVMConstNeg(LLVMValueRef ConstantVal);
public static native LLVMValueRef LLVMConstNSWNeg(LLVMValueRef ConstantVal);
public static native LLVMValueRef LLVMConstNUWNeg(LLVMValueRef ConstantVal);
public static native LLVMValueRef LLVMConstFNeg(LLVMValueRef ConstantVal);
public static native LLVMValueRef LLVMConstNot(LLVMValueRef ConstantVal);
public static native LLVMValueRef LLVMConstAdd(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstNSWAdd(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstNUWAdd(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstFAdd(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstSub(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstNSWSub(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstNUWSub(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstFSub(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstMul(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstNSWMul(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstNUWMul(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstFMul(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstUDiv(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstSDiv(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstExactSDiv(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstFDiv(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstURem(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstSRem(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstFRem(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstAnd(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstOr(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstXor(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstICmp(@Cast("LLVMIntPredicate") int Predicate,
                           LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstFCmp(@Cast("LLVMRealPredicate") int Predicate,
                           LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstShl(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstLShr(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstAShr(LLVMValueRef LHSConstant, LLVMValueRef RHSConstant);
public static native LLVMValueRef LLVMConstGEP(LLVMValueRef ConstantVal,
                          @ByPtrPtr LLVMValueRef ConstantIndices, @Cast("unsigned") int NumIndices);
public static native LLVMValueRef LLVMConstGEP(LLVMValueRef ConstantVal,
                          @Cast("LLVMValueRef*") PointerPointer ConstantIndices, @Cast("unsigned") int NumIndices);
public static native LLVMValueRef LLVMConstInBoundsGEP(LLVMValueRef ConstantVal,
                                  @ByPtrPtr LLVMValueRef ConstantIndices,
                                  @Cast("unsigned") int NumIndices);
public static native LLVMValueRef LLVMConstInBoundsGEP(LLVMValueRef ConstantVal,
                                  @Cast("LLVMValueRef*") PointerPointer ConstantIndices,
                                  @Cast("unsigned") int NumIndices);
public static native LLVMValueRef LLVMConstTrunc(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstSExt(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstZExt(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstFPTrunc(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstFPExt(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstUIToFP(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstSIToFP(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstFPToUI(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstFPToSI(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstPtrToInt(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstIntToPtr(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstBitCast(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstAddrSpaceCast(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstZExtOrBitCast(LLVMValueRef ConstantVal,
                                    LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstSExtOrBitCast(LLVMValueRef ConstantVal,
                                    LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstTruncOrBitCast(LLVMValueRef ConstantVal,
                                     LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstPointerCast(LLVMValueRef ConstantVal,
                                  LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstIntCast(LLVMValueRef ConstantVal, LLVMTypeRef ToType,
                              @Cast("LLVMBool") int isSigned);
public static native LLVMValueRef LLVMConstFPCast(LLVMValueRef ConstantVal, LLVMTypeRef ToType);
public static native LLVMValueRef LLVMConstSelect(LLVMValueRef ConstantCondition,
                             LLVMValueRef ConstantIfTrue,
                             LLVMValueRef ConstantIfFalse);
public static native LLVMValueRef LLVMConstExtractElement(LLVMValueRef VectorConstant,
                                     LLVMValueRef IndexConstant);
public static native LLVMValueRef LLVMConstInsertElement(LLVMValueRef VectorConstant,
                                    LLVMValueRef ElementValueConstant,
                                    LLVMValueRef IndexConstant);
public static native LLVMValueRef LLVMConstShuffleVector(LLVMValueRef VectorAConstant,
                                    LLVMValueRef VectorBConstant,
                                    LLVMValueRef MaskConstant);
public static native LLVMValueRef LLVMConstExtractValue(LLVMValueRef AggConstant, @Cast("unsigned*") IntPointer IdxList,
                                   @Cast("unsigned") int NumIdx);
public static native LLVMValueRef LLVMConstExtractValue(LLVMValueRef AggConstant, @Cast("unsigned*") IntBuffer IdxList,
                                   @Cast("unsigned") int NumIdx);
public static native LLVMValueRef LLVMConstExtractValue(LLVMValueRef AggConstant, @Cast("unsigned*") int[] IdxList,
                                   @Cast("unsigned") int NumIdx);
public static native LLVMValueRef LLVMConstInsertValue(LLVMValueRef AggConstant,
                                  LLVMValueRef ElementValueConstant,
                                  @Cast("unsigned*") IntPointer IdxList, @Cast("unsigned") int NumIdx);
public static native LLVMValueRef LLVMConstInsertValue(LLVMValueRef AggConstant,
                                  LLVMValueRef ElementValueConstant,
                                  @Cast("unsigned*") IntBuffer IdxList, @Cast("unsigned") int NumIdx);
public static native LLVMValueRef LLVMConstInsertValue(LLVMValueRef AggConstant,
                                  LLVMValueRef ElementValueConstant,
                                  @Cast("unsigned*") int[] IdxList, @Cast("unsigned") int NumIdx);
public static native LLVMValueRef LLVMConstInlineAsm(LLVMTypeRef Ty,
                                @Cast("const char*") BytePointer AsmString, @Cast("const char*") BytePointer Constraints,
                                @Cast("LLVMBool") int HasSideEffects, @Cast("LLVMBool") int IsAlignStack);
public static native LLVMValueRef LLVMConstInlineAsm(LLVMTypeRef Ty,
                                String AsmString, String Constraints,
                                @Cast("LLVMBool") int HasSideEffects, @Cast("LLVMBool") int IsAlignStack);
public static native LLVMValueRef LLVMBlockAddress(LLVMValueRef F, LLVMBasicBlockRef BB);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueConstantGlobals Global Values
 *
 * This group contains functions that operate on global values. Functions in
 * this group relate to functions in the llvm::GlobalValue class tree.
 *
 * @see llvm::GlobalValue
 *
 * @{
 */

public static native LLVMModuleRef LLVMGetGlobalParent(LLVMValueRef Global);
public static native @Cast("LLVMBool") int LLVMIsDeclaration(LLVMValueRef Global);
public static native @Cast("LLVMLinkage") int LLVMGetLinkage(LLVMValueRef Global);
public static native void LLVMSetLinkage(LLVMValueRef Global, @Cast("LLVMLinkage") int Linkage);
public static native @Cast("const char*") BytePointer LLVMGetSection(LLVMValueRef Global);
public static native void LLVMSetSection(LLVMValueRef Global, @Cast("const char*") BytePointer Section);
public static native void LLVMSetSection(LLVMValueRef Global, String Section);
public static native @Cast("LLVMVisibility") int LLVMGetVisibility(LLVMValueRef Global);
public static native void LLVMSetVisibility(LLVMValueRef Global, @Cast("LLVMVisibility") int Viz);
public static native @Cast("LLVMDLLStorageClass") int LLVMGetDLLStorageClass(LLVMValueRef Global);
public static native void LLVMSetDLLStorageClass(LLVMValueRef Global, @Cast("LLVMDLLStorageClass") int Class);
public static native @Cast("LLVMBool") int LLVMHasUnnamedAddr(LLVMValueRef Global);
public static native void LLVMSetUnnamedAddr(LLVMValueRef Global, @Cast("LLVMBool") int HasUnnamedAddr);

/**
 * @defgroup LLVMCCoreValueWithAlignment Values with alignment
 *
 * Functions in this group only apply to values with alignment, i.e.
 * global variables, load and store instructions.
 */

/**
 * Obtain the preferred alignment of the value.
 * @see llvm::AllocaInst::getAlignment()
 * @see llvm::LoadInst::getAlignment()
 * @see llvm::StoreInst::getAlignment()
 * @see llvm::GlobalValue::getAlignment()
 */
public static native @Cast("unsigned") int LLVMGetAlignment(LLVMValueRef V);

/**
 * Set the preferred alignment of the value.
 * @see llvm::AllocaInst::setAlignment()
 * @see llvm::LoadInst::setAlignment()
 * @see llvm::StoreInst::setAlignment()
 * @see llvm::GlobalValue::setAlignment()
 */
public static native void LLVMSetAlignment(LLVMValueRef V, @Cast("unsigned") int Bytes);

/**
  * @}
  */

/**
 * @defgroup LLVMCoreValueConstantGlobalVariable Global Variables
 *
 * This group contains functions that operate on global variable values.
 *
 * @see llvm::GlobalVariable
 *
 * @{
 */
public static native LLVMValueRef LLVMAddGlobal(LLVMModuleRef M, LLVMTypeRef Ty, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMAddGlobal(LLVMModuleRef M, LLVMTypeRef Ty, String Name);
public static native LLVMValueRef LLVMAddGlobalInAddressSpace(LLVMModuleRef M, LLVMTypeRef Ty,
                                         @Cast("const char*") BytePointer Name,
                                         @Cast("unsigned") int AddressSpace);
public static native LLVMValueRef LLVMAddGlobalInAddressSpace(LLVMModuleRef M, LLVMTypeRef Ty,
                                         String Name,
                                         @Cast("unsigned") int AddressSpace);
public static native LLVMValueRef LLVMGetNamedGlobal(LLVMModuleRef M, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMGetNamedGlobal(LLVMModuleRef M, String Name);
public static native LLVMValueRef LLVMGetFirstGlobal(LLVMModuleRef M);
public static native LLVMValueRef LLVMGetLastGlobal(LLVMModuleRef M);
public static native LLVMValueRef LLVMGetNextGlobal(LLVMValueRef GlobalVar);
public static native LLVMValueRef LLVMGetPreviousGlobal(LLVMValueRef GlobalVar);
public static native void LLVMDeleteGlobal(LLVMValueRef GlobalVar);
public static native LLVMValueRef LLVMGetInitializer(LLVMValueRef GlobalVar);
public static native void LLVMSetInitializer(LLVMValueRef GlobalVar, LLVMValueRef ConstantVal);
public static native @Cast("LLVMBool") int LLVMIsThreadLocal(LLVMValueRef GlobalVar);
public static native void LLVMSetThreadLocal(LLVMValueRef GlobalVar, @Cast("LLVMBool") int IsThreadLocal);
public static native @Cast("LLVMBool") int LLVMIsGlobalConstant(LLVMValueRef GlobalVar);
public static native void LLVMSetGlobalConstant(LLVMValueRef GlobalVar, @Cast("LLVMBool") int IsConstant);
public static native @Cast("LLVMThreadLocalMode") int LLVMGetThreadLocalMode(LLVMValueRef GlobalVar);
public static native void LLVMSetThreadLocalMode(LLVMValueRef GlobalVar, @Cast("LLVMThreadLocalMode") int Mode);
public static native @Cast("LLVMBool") int LLVMIsExternallyInitialized(LLVMValueRef GlobalVar);
public static native void LLVMSetExternallyInitialized(LLVMValueRef GlobalVar, @Cast("LLVMBool") int IsExtInit);

/**
 * @}
 */

/**
 * @defgroup LLVMCoreValueConstantGlobalAlias Global Aliases
 *
 * This group contains function that operate on global alias values.
 *
 * @see llvm::GlobalAlias
 *
 * @{
 */
public static native LLVMValueRef LLVMAddAlias(LLVMModuleRef M, LLVMTypeRef Ty, LLVMValueRef Aliasee,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMAddAlias(LLVMModuleRef M, LLVMTypeRef Ty, LLVMValueRef Aliasee,
                          String Name);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueFunction Function values
 *
 * Functions in this group operate on LLVMValueRef instances that
 * correspond to llvm::Function instances.
 *
 * @see llvm::Function
 *
 * @{
 */

/**
 * Remove a function from its containing module and deletes it.
 *
 * @see llvm::Function::eraseFromParent()
 */
public static native void LLVMDeleteFunction(LLVMValueRef Fn);

/**
 * Obtain the personality function attached to the function.
 *
 * @see llvm::Function::getPersonalityFn()
 */
public static native LLVMValueRef LLVMGetPersonalityFn(LLVMValueRef Fn);

/**
 * Set the personality function attached to the function.
 *
 * @see llvm::Function::setPersonalityFn()
 */
public static native void LLVMSetPersonalityFn(LLVMValueRef Fn, LLVMValueRef PersonalityFn);

/**
 * Obtain the ID number from a function instance.
 *
 * @see llvm::Function::getIntrinsicID()
 */
public static native @Cast("unsigned") int LLVMGetIntrinsicID(LLVMValueRef Fn);

/**
 * Obtain the calling function of a function.
 *
 * The returned value corresponds to the LLVMCallConv enumeration.
 *
 * @see llvm::Function::getCallingConv()
 */
public static native @Cast("unsigned") int LLVMGetFunctionCallConv(LLVMValueRef Fn);

/**
 * Set the calling convention of a function.
 *
 * @see llvm::Function::setCallingConv()
 *
 * @param Fn Function to operate on
 * @param CC LLVMCallConv to set calling convention to
 */
public static native void LLVMSetFunctionCallConv(LLVMValueRef Fn, @Cast("unsigned") int CC);

/**
 * Obtain the name of the garbage collector to use during code
 * generation.
 *
 * @see llvm::Function::getGC()
 */
public static native @Cast("const char*") BytePointer LLVMGetGC(LLVMValueRef Fn);

/**
 * Define the garbage collector to use during code generation.
 *
 * @see llvm::Function::setGC()
 */
public static native void LLVMSetGC(LLVMValueRef Fn, @Cast("const char*") BytePointer Name);
public static native void LLVMSetGC(LLVMValueRef Fn, String Name);

/**
 * Add an attribute to a function.
 *
 * @see llvm::Function::addAttribute()
 */
public static native void LLVMAddFunctionAttr(LLVMValueRef Fn, @Cast("LLVMAttribute") int PA);

/**
 * Add a target-dependent attribute to a fuction
 * @see llvm::AttrBuilder::addAttribute()
 */
public static native void LLVMAddTargetDependentFunctionAttr(LLVMValueRef Fn, @Cast("const char*") BytePointer A,
                                        @Cast("const char*") BytePointer V);
public static native void LLVMAddTargetDependentFunctionAttr(LLVMValueRef Fn, String A,
                                        String V);

/**
 * Obtain an attribute from a function.
 *
 * @see llvm::Function::getAttributes()
 */
public static native @Cast("LLVMAttribute") int LLVMGetFunctionAttr(LLVMValueRef Fn);

/**
 * Remove an attribute from a function.
 */
public static native void LLVMRemoveFunctionAttr(LLVMValueRef Fn, @Cast("LLVMAttribute") int PA);

/**
 * @defgroup LLVMCCoreValueFunctionParameters Function Parameters
 *
 * Functions in this group relate to arguments/parameters on functions.
 *
 * Functions in this group expect LLVMValueRef instances that correspond
 * to llvm::Function instances.
 *
 * @{
 */

/**
 * Obtain the number of parameters in a function.
 *
 * @see llvm::Function::arg_size()
 */
public static native @Cast("unsigned") int LLVMCountParams(LLVMValueRef Fn);

/**
 * Obtain the parameters in a function.
 *
 * The takes a pointer to a pre-allocated array of LLVMValueRef that is
 * at least LLVMCountParams() long. This array will be filled with
 * LLVMValueRef instances which correspond to the parameters the
 * function receives. Each LLVMValueRef corresponds to a llvm::Argument
 * instance.
 *
 * @see llvm::Function::arg_begin()
 */
public static native void LLVMGetParams(LLVMValueRef Fn, @ByPtrPtr LLVMValueRef Params);
public static native void LLVMGetParams(LLVMValueRef Fn, @Cast("LLVMValueRef*") PointerPointer Params);

/**
 * Obtain the parameter at the specified index.
 *
 * Parameters are indexed from 0.
 *
 * @see llvm::Function::arg_begin()
 */
public static native LLVMValueRef LLVMGetParam(LLVMValueRef Fn, @Cast("unsigned") int Index);

/**
 * Obtain the function to which this argument belongs.
 *
 * Unlike other functions in this group, this one takes an LLVMValueRef
 * that corresponds to a llvm::Attribute.
 *
 * The returned LLVMValueRef is the llvm::Function to which this
 * argument belongs.
 */
public static native LLVMValueRef LLVMGetParamParent(LLVMValueRef Inst);

/**
 * Obtain the first parameter to a function.
 *
 * @see llvm::Function::arg_begin()
 */
public static native LLVMValueRef LLVMGetFirstParam(LLVMValueRef Fn);

/**
 * Obtain the last parameter to a function.
 *
 * @see llvm::Function::arg_end()
 */
public static native LLVMValueRef LLVMGetLastParam(LLVMValueRef Fn);

/**
 * Obtain the next parameter to a function.
 *
 * This takes an LLVMValueRef obtained from LLVMGetFirstParam() (which is
 * actually a wrapped iterator) and obtains the next parameter from the
 * underlying iterator.
 */
public static native LLVMValueRef LLVMGetNextParam(LLVMValueRef Arg);

/**
 * Obtain the previous parameter to a function.
 *
 * This is the opposite of LLVMGetNextParam().
 */
public static native LLVMValueRef LLVMGetPreviousParam(LLVMValueRef Arg);

/**
 * Add an attribute to a function argument.
 *
 * @see llvm::Argument::addAttr()
 */
public static native void LLVMAddAttribute(LLVMValueRef Arg, @Cast("LLVMAttribute") int PA);

/**
 * Remove an attribute from a function argument.
 *
 * @see llvm::Argument::removeAttr()
 */
public static native void LLVMRemoveAttribute(LLVMValueRef Arg, @Cast("LLVMAttribute") int PA);

/**
 * Get an attribute from a function argument.
 */
public static native @Cast("LLVMAttribute") int LLVMGetAttribute(LLVMValueRef Arg);

/**
 * Set the alignment for a function parameter.
 *
 * @see llvm::Argument::addAttr()
 * @see llvm::AttrBuilder::addAlignmentAttr()
 */
public static native void LLVMSetParamAlignment(LLVMValueRef Arg, @Cast("unsigned") int align);

/**
 * @}
 */

/**
 * @}
 */

/**
 * @}
 */

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueMetadata Metadata
 *
 * @{
 */

/**
 * Obtain a MDString value from a context.
 *
 * The returned instance corresponds to the llvm::MDString class.
 *
 * The instance is specified by string data of a specified length. The
 * string content is copied, so the backing memory can be freed after
 * this function returns.
 */
public static native LLVMValueRef LLVMMDStringInContext(LLVMContextRef C, @Cast("const char*") BytePointer Str,
                                   @Cast("unsigned") int SLen);
public static native LLVMValueRef LLVMMDStringInContext(LLVMContextRef C, String Str,
                                   @Cast("unsigned") int SLen);

/**
 * Obtain a MDString value from the global context.
 */
public static native LLVMValueRef LLVMMDString(@Cast("const char*") BytePointer Str, @Cast("unsigned") int SLen);
public static native LLVMValueRef LLVMMDString(String Str, @Cast("unsigned") int SLen);

/**
 * Obtain a MDNode value from a context.
 *
 * The returned value corresponds to the llvm::MDNode class.
 */
public static native LLVMValueRef LLVMMDNodeInContext(LLVMContextRef C, @ByPtrPtr LLVMValueRef Vals,
                                 @Cast("unsigned") int Count);
public static native LLVMValueRef LLVMMDNodeInContext(LLVMContextRef C, @Cast("LLVMValueRef*") PointerPointer Vals,
                                 @Cast("unsigned") int Count);

/**
 * Obtain a MDNode value from the global context.
 */
public static native LLVMValueRef LLVMMDNode(@ByPtrPtr LLVMValueRef Vals, @Cast("unsigned") int Count);
public static native LLVMValueRef LLVMMDNode(@Cast("LLVMValueRef*") PointerPointer Vals, @Cast("unsigned") int Count);

/**
 * Obtain the underlying string from a MDString value.
 *
 * @param V Instance to obtain string from.
 * @param Len Memory address which will hold length of returned string.
 * @return String data in MDString.
 */
public static native @Cast("const char*") BytePointer LLVMGetMDString(LLVMValueRef V, @Cast("unsigned*") IntPointer Len);
public static native String LLVMGetMDString(LLVMValueRef V, @Cast("unsigned*") IntBuffer Len);
public static native @Cast("const char*") BytePointer LLVMGetMDString(LLVMValueRef V, @Cast("unsigned*") int[] Len);

/**
 * Obtain the number of operands from an MDNode value.
 *
 * @param V MDNode to get number of operands from.
 * @return Number of operands of the MDNode.
 */
public static native @Cast("unsigned") int LLVMGetMDNodeNumOperands(LLVMValueRef V);

/**
 * Obtain the given MDNode's operands.
 *
 * The passed LLVMValueRef pointer should point to enough memory to hold all of
 * the operands of the given MDNode (see LLVMGetMDNodeNumOperands) as
 * LLVMValueRefs. This memory will be populated with the LLVMValueRefs of the
 * MDNode's operands.
 *
 * @param V MDNode to get the operands from.
 * @param Dest Destination array for operands.
 */
public static native void LLVMGetMDNodeOperands(LLVMValueRef V, @ByPtrPtr LLVMValueRef Dest);
public static native void LLVMGetMDNodeOperands(LLVMValueRef V, @Cast("LLVMValueRef*") PointerPointer Dest);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueBasicBlock Basic Block
 *
 * A basic block represents a single entry single exit section of code.
 * Basic blocks contain a list of instructions which form the body of
 * the block.
 *
 * Basic blocks belong to functions. They have the type of label.
 *
 * Basic blocks are themselves values. However, the C API models them as
 * LLVMBasicBlockRef.
 *
 * @see llvm::BasicBlock
 *
 * @{
 */

/**
 * Convert a basic block instance to a value type.
 */
public static native LLVMValueRef LLVMBasicBlockAsValue(LLVMBasicBlockRef BB);

/**
 * Determine whether an LLVMValueRef is itself a basic block.
 */
public static native @Cast("LLVMBool") int LLVMValueIsBasicBlock(LLVMValueRef Val);

/**
 * Convert an LLVMValueRef to an LLVMBasicBlockRef instance.
 */
public static native LLVMBasicBlockRef LLVMValueAsBasicBlock(LLVMValueRef Val);

/**
 * Obtain the function to which a basic block belongs.
 *
 * @see llvm::BasicBlock::getParent()
 */
public static native LLVMValueRef LLVMGetBasicBlockParent(LLVMBasicBlockRef BB);

/**
 * Obtain the terminator instruction for a basic block.
 *
 * If the basic block does not have a terminator (it is not well-formed
 * if it doesn't), then NULL is returned.
 *
 * The returned LLVMValueRef corresponds to a llvm::TerminatorInst.
 *
 * @see llvm::BasicBlock::getTerminator()
 */
public static native LLVMValueRef LLVMGetBasicBlockTerminator(LLVMBasicBlockRef BB);

/**
 * Obtain the number of basic blocks in a function.
 *
 * @param Fn Function value to operate on.
 */
public static native @Cast("unsigned") int LLVMCountBasicBlocks(LLVMValueRef Fn);

/**
 * Obtain all of the basic blocks in a function.
 *
 * This operates on a function value. The BasicBlocks parameter is a
 * pointer to a pre-allocated array of LLVMBasicBlockRef of at least
 * LLVMCountBasicBlocks() in length. This array is populated with
 * LLVMBasicBlockRef instances.
 */
public static native void LLVMGetBasicBlocks(LLVMValueRef Fn, @ByPtrPtr LLVMBasicBlockRef BasicBlocks);
public static native void LLVMGetBasicBlocks(LLVMValueRef Fn, @Cast("LLVMBasicBlockRef*") PointerPointer BasicBlocks);

/**
 * Obtain the first basic block in a function.
 *
 * The returned basic block can be used as an iterator. You will likely
 * eventually call into LLVMGetNextBasicBlock() with it.
 *
 * @see llvm::Function::begin()
 */
public static native LLVMBasicBlockRef LLVMGetFirstBasicBlock(LLVMValueRef Fn);

/**
 * Obtain the last basic block in a function.
 *
 * @see llvm::Function::end()
 */
public static native LLVMBasicBlockRef LLVMGetLastBasicBlock(LLVMValueRef Fn);

/**
 * Advance a basic block iterator.
 */
public static native LLVMBasicBlockRef LLVMGetNextBasicBlock(LLVMBasicBlockRef BB);

/**
 * Go backwards in a basic block iterator.
 */
public static native LLVMBasicBlockRef LLVMGetPreviousBasicBlock(LLVMBasicBlockRef BB);

/**
 * Obtain the basic block that corresponds to the entry point of a
 * function.
 *
 * @see llvm::Function::getEntryBlock()
 */
public static native LLVMBasicBlockRef LLVMGetEntryBasicBlock(LLVMValueRef Fn);

/**
 * Append a basic block to the end of a function.
 *
 * @see llvm::BasicBlock::Create()
 */
public static native LLVMBasicBlockRef LLVMAppendBasicBlockInContext(LLVMContextRef C,
                                                LLVMValueRef Fn,
                                                @Cast("const char*") BytePointer Name);
public static native LLVMBasicBlockRef LLVMAppendBasicBlockInContext(LLVMContextRef C,
                                                LLVMValueRef Fn,
                                                String Name);

/**
 * Append a basic block to the end of a function using the global
 * context.
 *
 * @see llvm::BasicBlock::Create()
 */
public static native LLVMBasicBlockRef LLVMAppendBasicBlock(LLVMValueRef Fn, @Cast("const char*") BytePointer Name);
public static native LLVMBasicBlockRef LLVMAppendBasicBlock(LLVMValueRef Fn, String Name);

/**
 * Insert a basic block in a function before another basic block.
 *
 * The function to add to is determined by the function of the
 * passed basic block.
 *
 * @see llvm::BasicBlock::Create()
 */
public static native LLVMBasicBlockRef LLVMInsertBasicBlockInContext(LLVMContextRef C,
                                                LLVMBasicBlockRef BB,
                                                @Cast("const char*") BytePointer Name);
public static native LLVMBasicBlockRef LLVMInsertBasicBlockInContext(LLVMContextRef C,
                                                LLVMBasicBlockRef BB,
                                                String Name);

/**
 * Insert a basic block in a function using the global context.
 *
 * @see llvm::BasicBlock::Create()
 */
public static native LLVMBasicBlockRef LLVMInsertBasicBlock(LLVMBasicBlockRef InsertBeforeBB,
                                       @Cast("const char*") BytePointer Name);
public static native LLVMBasicBlockRef LLVMInsertBasicBlock(LLVMBasicBlockRef InsertBeforeBB,
                                       String Name);

/**
 * Remove a basic block from a function and delete it.
 *
 * This deletes the basic block from its containing function and deletes
 * the basic block itself.
 *
 * @see llvm::BasicBlock::eraseFromParent()
 */
public static native void LLVMDeleteBasicBlock(LLVMBasicBlockRef BB);

/**
 * Remove a basic block from a function.
 *
 * This deletes the basic block from its containing function but keep
 * the basic block alive.
 *
 * @see llvm::BasicBlock::removeFromParent()
 */
public static native void LLVMRemoveBasicBlockFromParent(LLVMBasicBlockRef BB);

/**
 * Move a basic block to before another one.
 *
 * @see llvm::BasicBlock::moveBefore()
 */
public static native void LLVMMoveBasicBlockBefore(LLVMBasicBlockRef BB, LLVMBasicBlockRef MovePos);

/**
 * Move a basic block to after another one.
 *
 * @see llvm::BasicBlock::moveAfter()
 */
public static native void LLVMMoveBasicBlockAfter(LLVMBasicBlockRef BB, LLVMBasicBlockRef MovePos);

/**
 * Obtain the first instruction in a basic block.
 *
 * The returned LLVMValueRef corresponds to a llvm::Instruction
 * instance.
 */
public static native LLVMValueRef LLVMGetFirstInstruction(LLVMBasicBlockRef BB);

/**
 * Obtain the last instruction in a basic block.
 *
 * The returned LLVMValueRef corresponds to an LLVM:Instruction.
 */
public static native LLVMValueRef LLVMGetLastInstruction(LLVMBasicBlockRef BB);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueInstruction Instructions
 *
 * Functions in this group relate to the inspection and manipulation of
 * individual instructions.
 *
 * In the C++ API, an instruction is modeled by llvm::Instruction. This
 * class has a large number of descendents. llvm::Instruction is a
 * llvm::Value and in the C API, instructions are modeled by
 * LLVMValueRef.
 *
 * This group also contains sub-groups which operate on specific
 * llvm::Instruction types, e.g. llvm::CallInst.
 *
 * @{
 */

/**
 * Determine whether an instruction has any metadata attached.
 */
public static native int LLVMHasMetadata(LLVMValueRef Val);

/**
 * Return metadata associated with an instruction value.
 */
public static native LLVMValueRef LLVMGetMetadata(LLVMValueRef Val, @Cast("unsigned") int KindID);

/**
 * Set metadata associated with an instruction value.
 */
public static native void LLVMSetMetadata(LLVMValueRef Val, @Cast("unsigned") int KindID, LLVMValueRef Node);

/**
 * Obtain the basic block to which an instruction belongs.
 *
 * @see llvm::Instruction::getParent()
 */
public static native LLVMBasicBlockRef LLVMGetInstructionParent(LLVMValueRef Inst);

/**
 * Obtain the instruction that occurs after the one specified.
 *
 * The next instruction will be from the same basic block.
 *
 * If this is the last instruction in a basic block, NULL will be
 * returned.
 */
public static native LLVMValueRef LLVMGetNextInstruction(LLVMValueRef Inst);

/**
 * Obtain the instruction that occurred before this one.
 *
 * If the instruction is the first instruction in a basic block, NULL
 * will be returned.
 */
public static native LLVMValueRef LLVMGetPreviousInstruction(LLVMValueRef Inst);

/**
 * Remove and delete an instruction.
 *
 * The instruction specified is removed from its containing building
 * block and then deleted.
 *
 * @see llvm::Instruction::eraseFromParent()
 */
public static native void LLVMInstructionEraseFromParent(LLVMValueRef Inst);

/**
 * Obtain the code opcode for an individual instruction.
 *
 * @see llvm::Instruction::getOpCode()
 */
public static native @Cast("LLVMOpcode") int LLVMGetInstructionOpcode(LLVMValueRef Inst);

/**
 * Obtain the predicate of an instruction.
 *
 * This is only valid for instructions that correspond to llvm::ICmpInst
 * or llvm::ConstantExpr whose opcode is llvm::Instruction::ICmp.
 *
 * @see llvm::ICmpInst::getPredicate()
 */
public static native @Cast("LLVMIntPredicate") int LLVMGetICmpPredicate(LLVMValueRef Inst);

/**
 * Obtain the float predicate of an instruction.
 *
 * This is only valid for instructions that correspond to llvm::FCmpInst
 * or llvm::ConstantExpr whose opcode is llvm::Instruction::FCmp.
 *
 * @see llvm::FCmpInst::getPredicate()
 */
public static native @Cast("LLVMRealPredicate") int LLVMGetFCmpPredicate(LLVMValueRef Inst);

/**
 * Create a copy of 'this' instruction that is identical in all ways
 * except the following:
 *   * The instruction has no parent
 *   * The instruction has no name
 *
 * @see llvm::Instruction::clone()
 */
public static native LLVMValueRef LLVMInstructionClone(LLVMValueRef Inst);

/**
 * @defgroup LLVMCCoreValueInstructionCall Call Sites and Invocations
 *
 * Functions in this group apply to instructions that refer to call
 * sites and invocations. These correspond to C++ types in the
 * llvm::CallInst class tree.
 *
 * @{
 */

/**
 * Set the calling convention for a call instruction.
 *
 * This expects an LLVMValueRef that corresponds to a llvm::CallInst or
 * llvm::InvokeInst.
 *
 * @see llvm::CallInst::setCallingConv()
 * @see llvm::InvokeInst::setCallingConv()
 */
public static native void LLVMSetInstructionCallConv(LLVMValueRef Instr, @Cast("unsigned") int CC);

/**
 * Obtain the calling convention for a call instruction.
 *
 * This is the opposite of LLVMSetInstructionCallConv(). Reads its
 * usage.
 *
 * @see LLVMSetInstructionCallConv()
 */
public static native @Cast("unsigned") int LLVMGetInstructionCallConv(LLVMValueRef Instr);


public static native void LLVMAddInstrAttribute(LLVMValueRef Instr, @Cast("unsigned") int index, @Cast("LLVMAttribute") int arg2);
public static native void LLVMRemoveInstrAttribute(LLVMValueRef Instr, @Cast("unsigned") int index,
                              @Cast("LLVMAttribute") int arg2);
public static native void LLVMSetInstrParamAlignment(LLVMValueRef Instr, @Cast("unsigned") int index,
                                @Cast("unsigned") int align);

/**
 * Obtain whether a call instruction is a tail call.
 *
 * This only works on llvm::CallInst instructions.
 *
 * @see llvm::CallInst::isTailCall()
 */
public static native @Cast("LLVMBool") int LLVMIsTailCall(LLVMValueRef CallInst);

/**
 * Set whether a call instruction is a tail call.
 *
 * This only works on llvm::CallInst instructions.
 *
 * @see llvm::CallInst::setTailCall()
 */
public static native void LLVMSetTailCall(LLVMValueRef CallInst, @Cast("LLVMBool") int IsTailCall);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueInstructionTerminator Terminators
 *
 * Functions in this group only apply to instructions that map to
 * llvm::TerminatorInst instances.
 *
 * @{
 */

/**
 * Return the number of successors that this terminator has.
 *
 * @see llvm::TerminatorInst::getNumSuccessors
 */
public static native @Cast("unsigned") int LLVMGetNumSuccessors(LLVMValueRef Term);

/**
 * Return the specified successor.
 *
 * @see llvm::TerminatorInst::getSuccessor
 */
public static native LLVMBasicBlockRef LLVMGetSuccessor(LLVMValueRef Term, @Cast("unsigned") int i);

/**
 * Update the specified successor to point at the provided block.
 *
 * @see llvm::TerminatorInst::setSuccessor
 */
public static native void LLVMSetSuccessor(LLVMValueRef Term, @Cast("unsigned") int i, LLVMBasicBlockRef block);

/**
 * Return if a branch is conditional.
 *
 * This only works on llvm::BranchInst instructions.
 *
 * @see llvm::BranchInst::isConditional
 */
public static native @Cast("LLVMBool") int LLVMIsConditional(LLVMValueRef Branch);

/**
 * Return the condition of a branch instruction.
 *
 * This only works on llvm::BranchInst instructions.
 *
 * @see llvm::BranchInst::getCondition
 */
public static native LLVMValueRef LLVMGetCondition(LLVMValueRef Branch);

/**
 * Set the condition of a branch instruction.
 *
 * This only works on llvm::BranchInst instructions.
 *
 * @see llvm::BranchInst::setCondition
 */
public static native void LLVMSetCondition(LLVMValueRef Branch, LLVMValueRef Cond);

/**
 * Obtain the default destination basic block of a switch instruction.
 *
 * This only works on llvm::SwitchInst instructions.
 *
 * @see llvm::SwitchInst::getDefaultDest()
 */
public static native LLVMBasicBlockRef LLVMGetSwitchDefaultDest(LLVMValueRef SwitchInstr);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreValueInstructionPHINode PHI Nodes
 *
 * Functions in this group only apply to instructions that map to
 * llvm::PHINode instances.
 *
 * @{
 */

/**
 * Add an incoming value to the end of a PHI list.
 */
public static native void LLVMAddIncoming(LLVMValueRef PhiNode, @ByPtrPtr LLVMValueRef IncomingValues,
                     @ByPtrPtr LLVMBasicBlockRef IncomingBlocks, @Cast("unsigned") int Count);
public static native void LLVMAddIncoming(LLVMValueRef PhiNode, @Cast("LLVMValueRef*") PointerPointer IncomingValues,
                     @Cast("LLVMBasicBlockRef*") PointerPointer IncomingBlocks, @Cast("unsigned") int Count);

/**
 * Obtain the number of incoming basic blocks to a PHI node.
 */
public static native @Cast("unsigned") int LLVMCountIncoming(LLVMValueRef PhiNode);

/**
 * Obtain an incoming value to a PHI node as an LLVMValueRef.
 */
public static native LLVMValueRef LLVMGetIncomingValue(LLVMValueRef PhiNode, @Cast("unsigned") int Index);

/**
 * Obtain an incoming value to a PHI node as an LLVMBasicBlockRef.
 */
public static native LLVMBasicBlockRef LLVMGetIncomingBlock(LLVMValueRef PhiNode, @Cast("unsigned") int Index);

/**
 * @}
 */

/**
 * @}
 */

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreInstructionBuilder Instruction Builders
 *
 * An instruction builder represents a point within a basic block and is
 * the exclusive means of building instructions using the C interface.
 *
 * @{
 */

public static native LLVMBuilderRef LLVMCreateBuilderInContext(LLVMContextRef C);
public static native LLVMBuilderRef LLVMCreateBuilder();
public static native void LLVMPositionBuilder(LLVMBuilderRef Builder, LLVMBasicBlockRef Block,
                         LLVMValueRef Instr);
public static native void LLVMPositionBuilderBefore(LLVMBuilderRef Builder, LLVMValueRef Instr);
public static native void LLVMPositionBuilderAtEnd(LLVMBuilderRef Builder, LLVMBasicBlockRef Block);
public static native LLVMBasicBlockRef LLVMGetInsertBlock(LLVMBuilderRef Builder);
public static native void LLVMClearInsertionPosition(LLVMBuilderRef Builder);
public static native void LLVMInsertIntoBuilder(LLVMBuilderRef Builder, LLVMValueRef Instr);
public static native void LLVMInsertIntoBuilderWithName(LLVMBuilderRef Builder, LLVMValueRef Instr,
                                   @Cast("const char*") BytePointer Name);
public static native void LLVMInsertIntoBuilderWithName(LLVMBuilderRef Builder, LLVMValueRef Instr,
                                   String Name);
public static native void LLVMDisposeBuilder(LLVMBuilderRef Builder);

/* Metadata */
public static native void LLVMSetCurrentDebugLocation(LLVMBuilderRef Builder, LLVMValueRef L);
public static native LLVMValueRef LLVMGetCurrentDebugLocation(LLVMBuilderRef Builder);
public static native void LLVMSetInstDebugLocation(LLVMBuilderRef Builder, LLVMValueRef Inst);

/* Terminators */
public static native LLVMValueRef LLVMBuildRetVoid(LLVMBuilderRef arg0);
public static native LLVMValueRef LLVMBuildRet(LLVMBuilderRef arg0, LLVMValueRef V);
public static native LLVMValueRef LLVMBuildAggregateRet(LLVMBuilderRef arg0, @ByPtrPtr LLVMValueRef RetVals,
                                   @Cast("unsigned") int N);
public static native LLVMValueRef LLVMBuildAggregateRet(LLVMBuilderRef arg0, @Cast("LLVMValueRef*") PointerPointer RetVals,
                                   @Cast("unsigned") int N);
public static native LLVMValueRef LLVMBuildBr(LLVMBuilderRef arg0, LLVMBasicBlockRef Dest);
public static native LLVMValueRef LLVMBuildCondBr(LLVMBuilderRef arg0, LLVMValueRef If,
                             LLVMBasicBlockRef Then, LLVMBasicBlockRef Else);
public static native LLVMValueRef LLVMBuildSwitch(LLVMBuilderRef arg0, LLVMValueRef V,
                             LLVMBasicBlockRef Else, @Cast("unsigned") int NumCases);
public static native LLVMValueRef LLVMBuildIndirectBr(LLVMBuilderRef B, LLVMValueRef Addr,
                                 @Cast("unsigned") int NumDests);
public static native LLVMValueRef LLVMBuildInvoke(LLVMBuilderRef arg0, LLVMValueRef Fn,
                             @ByPtrPtr LLVMValueRef Args, @Cast("unsigned") int NumArgs,
                             LLVMBasicBlockRef Then, LLVMBasicBlockRef Catch,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildInvoke(LLVMBuilderRef arg0, LLVMValueRef Fn,
                             @Cast("LLVMValueRef*") PointerPointer Args, @Cast("unsigned") int NumArgs,
                             LLVMBasicBlockRef Then, LLVMBasicBlockRef Catch,
                             String Name);
public static native LLVMValueRef LLVMBuildLandingPad(LLVMBuilderRef B, LLVMTypeRef Ty,
                                 @Cast("unsigned") int NumClauses, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildLandingPad(LLVMBuilderRef B, LLVMTypeRef Ty,
                                 @Cast("unsigned") int NumClauses, String Name);
public static native LLVMValueRef LLVMBuildResume(LLVMBuilderRef B, LLVMValueRef Exn);
public static native LLVMValueRef LLVMBuildUnreachable(LLVMBuilderRef arg0);

/* Add a case to the switch instruction */
public static native void LLVMAddCase(LLVMValueRef Switch, LLVMValueRef OnVal,
                 LLVMBasicBlockRef Dest);

/* Add a destination to the indirectbr instruction */
public static native void LLVMAddDestination(LLVMValueRef IndirectBr, LLVMBasicBlockRef Dest);

/* Add a catch or filter clause to the landingpad instruction */
public static native void LLVMAddClause(LLVMValueRef LandingPad, LLVMValueRef ClauseVal);

/* Set the 'cleanup' flag in the landingpad instruction */
public static native void LLVMSetCleanup(LLVMValueRef LandingPad, @Cast("LLVMBool") int Val);

/* Arithmetic */
public static native LLVMValueRef LLVMBuildAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          String Name);
public static native LLVMValueRef LLVMBuildNSWAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNSWAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             String Name);
public static native LLVMValueRef LLVMBuildNUWAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNUWAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             String Name);
public static native LLVMValueRef LLVMBuildFAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFAdd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          String Name);
public static native LLVMValueRef LLVMBuildNSWSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNSWSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             String Name);
public static native LLVMValueRef LLVMBuildNUWSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNUWSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             String Name);
public static native LLVMValueRef LLVMBuildFSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFSub(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          String Name);
public static native LLVMValueRef LLVMBuildNSWMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNSWMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             String Name);
public static native LLVMValueRef LLVMBuildNUWMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNUWMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                             String Name);
public static native LLVMValueRef LLVMBuildFMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFMul(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildUDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildUDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildSDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildExactSDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                                @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildExactSDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                                String Name);
public static native LLVMValueRef LLVMBuildFDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFDiv(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildURem(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildURem(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildSRem(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSRem(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildFRem(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFRem(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildShl(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildShl(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildLShr(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildLShr(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildAShr(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildAShr(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildAnd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildAnd(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          String Name);
public static native LLVMValueRef LLVMBuildOr(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildOr(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          String Name);
public static native LLVMValueRef LLVMBuildXor(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildXor(LLVMBuilderRef arg0, LLVMValueRef LHS, LLVMValueRef RHS,
                          String Name);
public static native LLVMValueRef LLVMBuildBinOp(LLVMBuilderRef B, @Cast("LLVMOpcode") int Op,
                            LLVMValueRef LHS, LLVMValueRef RHS,
                            @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildBinOp(LLVMBuilderRef B, @Cast("LLVMOpcode") int Op,
                            LLVMValueRef LHS, LLVMValueRef RHS,
                            String Name);
public static native LLVMValueRef LLVMBuildNeg(LLVMBuilderRef arg0, LLVMValueRef V, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNeg(LLVMBuilderRef arg0, LLVMValueRef V, String Name);
public static native LLVMValueRef LLVMBuildNSWNeg(LLVMBuilderRef B, LLVMValueRef V,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNSWNeg(LLVMBuilderRef B, LLVMValueRef V,
                             String Name);
public static native LLVMValueRef LLVMBuildNUWNeg(LLVMBuilderRef B, LLVMValueRef V,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNUWNeg(LLVMBuilderRef B, LLVMValueRef V,
                             String Name);
public static native LLVMValueRef LLVMBuildFNeg(LLVMBuilderRef arg0, LLVMValueRef V, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFNeg(LLVMBuilderRef arg0, LLVMValueRef V, String Name);
public static native LLVMValueRef LLVMBuildNot(LLVMBuilderRef arg0, LLVMValueRef V, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildNot(LLVMBuilderRef arg0, LLVMValueRef V, String Name);

/* Memory */
public static native LLVMValueRef LLVMBuildMalloc(LLVMBuilderRef arg0, LLVMTypeRef Ty, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildMalloc(LLVMBuilderRef arg0, LLVMTypeRef Ty, String Name);
public static native LLVMValueRef LLVMBuildArrayMalloc(LLVMBuilderRef arg0, LLVMTypeRef Ty,
                                  LLVMValueRef Val, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildArrayMalloc(LLVMBuilderRef arg0, LLVMTypeRef Ty,
                                  LLVMValueRef Val, String Name);
public static native LLVMValueRef LLVMBuildAlloca(LLVMBuilderRef arg0, LLVMTypeRef Ty, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildAlloca(LLVMBuilderRef arg0, LLVMTypeRef Ty, String Name);
public static native LLVMValueRef LLVMBuildArrayAlloca(LLVMBuilderRef arg0, LLVMTypeRef Ty,
                                  LLVMValueRef Val, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildArrayAlloca(LLVMBuilderRef arg0, LLVMTypeRef Ty,
                                  LLVMValueRef Val, String Name);
public static native LLVMValueRef LLVMBuildFree(LLVMBuilderRef arg0, LLVMValueRef PointerVal);
public static native LLVMValueRef LLVMBuildLoad(LLVMBuilderRef arg0, LLVMValueRef PointerVal,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildLoad(LLVMBuilderRef arg0, LLVMValueRef PointerVal,
                           String Name);
public static native LLVMValueRef LLVMBuildStore(LLVMBuilderRef arg0, LLVMValueRef Val, LLVMValueRef Ptr);
public static native LLVMValueRef LLVMBuildGEP(LLVMBuilderRef B, LLVMValueRef Pointer,
                          @ByPtrPtr LLVMValueRef Indices, @Cast("unsigned") int NumIndices,
                          @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildGEP(LLVMBuilderRef B, LLVMValueRef Pointer,
                          @Cast("LLVMValueRef*") PointerPointer Indices, @Cast("unsigned") int NumIndices,
                          String Name);
public static native LLVMValueRef LLVMBuildInBoundsGEP(LLVMBuilderRef B, LLVMValueRef Pointer,
                                  @ByPtrPtr LLVMValueRef Indices, @Cast("unsigned") int NumIndices,
                                  @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildInBoundsGEP(LLVMBuilderRef B, LLVMValueRef Pointer,
                                  @Cast("LLVMValueRef*") PointerPointer Indices, @Cast("unsigned") int NumIndices,
                                  String Name);
public static native LLVMValueRef LLVMBuildStructGEP(LLVMBuilderRef B, LLVMValueRef Pointer,
                                @Cast("unsigned") int Idx, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildStructGEP(LLVMBuilderRef B, LLVMValueRef Pointer,
                                @Cast("unsigned") int Idx, String Name);
public static native LLVMValueRef LLVMBuildGlobalString(LLVMBuilderRef B, @Cast("const char*") BytePointer Str,
                                   @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildGlobalString(LLVMBuilderRef B, String Str,
                                   String Name);
public static native LLVMValueRef LLVMBuildGlobalStringPtr(LLVMBuilderRef B, @Cast("const char*") BytePointer Str,
                                      @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildGlobalStringPtr(LLVMBuilderRef B, String Str,
                                      String Name);
public static native @Cast("LLVMBool") int LLVMGetVolatile(LLVMValueRef MemoryAccessInst);
public static native void LLVMSetVolatile(LLVMValueRef MemoryAccessInst, @Cast("LLVMBool") int IsVolatile);

/* Casts */
public static native LLVMValueRef LLVMBuildTrunc(LLVMBuilderRef arg0, LLVMValueRef Val,
                            LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildTrunc(LLVMBuilderRef arg0, LLVMValueRef Val,
                            LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildZExt(LLVMBuilderRef arg0, LLVMValueRef Val,
                           LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildZExt(LLVMBuilderRef arg0, LLVMValueRef Val,
                           LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildSExt(LLVMBuilderRef arg0, LLVMValueRef Val,
                           LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSExt(LLVMBuilderRef arg0, LLVMValueRef Val,
                           LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildFPToUI(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFPToUI(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildFPToSI(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFPToSI(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildUIToFP(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildUIToFP(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildSIToFP(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSIToFP(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildFPTrunc(LLVMBuilderRef arg0, LLVMValueRef Val,
                              LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFPTrunc(LLVMBuilderRef arg0, LLVMValueRef Val,
                              LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildFPExt(LLVMBuilderRef arg0, LLVMValueRef Val,
                            LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFPExt(LLVMBuilderRef arg0, LLVMValueRef Val,
                            LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildPtrToInt(LLVMBuilderRef arg0, LLVMValueRef Val,
                               LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildPtrToInt(LLVMBuilderRef arg0, LLVMValueRef Val,
                               LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildIntToPtr(LLVMBuilderRef arg0, LLVMValueRef Val,
                               LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildIntToPtr(LLVMBuilderRef arg0, LLVMValueRef Val,
                               LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                              LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                              LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildAddrSpaceCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                    LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildAddrSpaceCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                    LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildZExtOrBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                    LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildZExtOrBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                    LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildSExtOrBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                    LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSExtOrBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                    LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildTruncOrBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                     LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildTruncOrBitCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                     LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildCast(LLVMBuilderRef B, @Cast("LLVMOpcode") int Op, LLVMValueRef Val,
                           LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildCast(LLVMBuilderRef B, @Cast("LLVMOpcode") int Op, LLVMValueRef Val,
                           LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildPointerCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                  LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildPointerCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                                  LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildIntCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                              LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildIntCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                              LLVMTypeRef DestTy, String Name);
public static native LLVMValueRef LLVMBuildFPCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFPCast(LLVMBuilderRef arg0, LLVMValueRef Val,
                             LLVMTypeRef DestTy, String Name);

/* Comparisons */
public static native LLVMValueRef LLVMBuildICmp(LLVMBuilderRef arg0, @Cast("LLVMIntPredicate") int Op,
                           LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildICmp(LLVMBuilderRef arg0, @Cast("LLVMIntPredicate") int Op,
                           LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);
public static native LLVMValueRef LLVMBuildFCmp(LLVMBuilderRef arg0, @Cast("LLVMRealPredicate") int Op,
                           LLVMValueRef LHS, LLVMValueRef RHS,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFCmp(LLVMBuilderRef arg0, @Cast("LLVMRealPredicate") int Op,
                           LLVMValueRef LHS, LLVMValueRef RHS,
                           String Name);

/* Miscellaneous instructions */
public static native LLVMValueRef LLVMBuildPhi(LLVMBuilderRef arg0, LLVMTypeRef Ty, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildPhi(LLVMBuilderRef arg0, LLVMTypeRef Ty, String Name);
public static native LLVMValueRef LLVMBuildCall(LLVMBuilderRef arg0, LLVMValueRef Fn,
                           @ByPtrPtr LLVMValueRef Args, @Cast("unsigned") int NumArgs,
                           @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildCall(LLVMBuilderRef arg0, LLVMValueRef Fn,
                           @Cast("LLVMValueRef*") PointerPointer Args, @Cast("unsigned") int NumArgs,
                           String Name);
public static native LLVMValueRef LLVMBuildSelect(LLVMBuilderRef arg0, LLVMValueRef If,
                             LLVMValueRef Then, LLVMValueRef Else,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildSelect(LLVMBuilderRef arg0, LLVMValueRef If,
                             LLVMValueRef Then, LLVMValueRef Else,
                             String Name);
public static native LLVMValueRef LLVMBuildVAArg(LLVMBuilderRef arg0, LLVMValueRef List, LLVMTypeRef Ty,
                            @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildVAArg(LLVMBuilderRef arg0, LLVMValueRef List, LLVMTypeRef Ty,
                            String Name);
public static native LLVMValueRef LLVMBuildExtractElement(LLVMBuilderRef arg0, LLVMValueRef VecVal,
                                     LLVMValueRef Index, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildExtractElement(LLVMBuilderRef arg0, LLVMValueRef VecVal,
                                     LLVMValueRef Index, String Name);
public static native LLVMValueRef LLVMBuildInsertElement(LLVMBuilderRef arg0, LLVMValueRef VecVal,
                                    LLVMValueRef EltVal, LLVMValueRef Index,
                                    @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildInsertElement(LLVMBuilderRef arg0, LLVMValueRef VecVal,
                                    LLVMValueRef EltVal, LLVMValueRef Index,
                                    String Name);
public static native LLVMValueRef LLVMBuildShuffleVector(LLVMBuilderRef arg0, LLVMValueRef V1,
                                    LLVMValueRef V2, LLVMValueRef Mask,
                                    @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildShuffleVector(LLVMBuilderRef arg0, LLVMValueRef V1,
                                    LLVMValueRef V2, LLVMValueRef Mask,
                                    String Name);
public static native LLVMValueRef LLVMBuildExtractValue(LLVMBuilderRef arg0, LLVMValueRef AggVal,
                                   @Cast("unsigned") int Index, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildExtractValue(LLVMBuilderRef arg0, LLVMValueRef AggVal,
                                   @Cast("unsigned") int Index, String Name);
public static native LLVMValueRef LLVMBuildInsertValue(LLVMBuilderRef arg0, LLVMValueRef AggVal,
                                  LLVMValueRef EltVal, @Cast("unsigned") int Index,
                                  @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildInsertValue(LLVMBuilderRef arg0, LLVMValueRef AggVal,
                                  LLVMValueRef EltVal, @Cast("unsigned") int Index,
                                  String Name);

public static native LLVMValueRef LLVMBuildIsNull(LLVMBuilderRef arg0, LLVMValueRef Val,
                             @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildIsNull(LLVMBuilderRef arg0, LLVMValueRef Val,
                             String Name);
public static native LLVMValueRef LLVMBuildIsNotNull(LLVMBuilderRef arg0, LLVMValueRef Val,
                                @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildIsNotNull(LLVMBuilderRef arg0, LLVMValueRef Val,
                                String Name);
public static native LLVMValueRef LLVMBuildPtrDiff(LLVMBuilderRef arg0, LLVMValueRef LHS,
                              LLVMValueRef RHS, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildPtrDiff(LLVMBuilderRef arg0, LLVMValueRef LHS,
                              LLVMValueRef RHS, String Name);
public static native LLVMValueRef LLVMBuildFence(LLVMBuilderRef B, @Cast("LLVMAtomicOrdering") int ordering,
                            @Cast("LLVMBool") int singleThread, @Cast("const char*") BytePointer Name);
public static native LLVMValueRef LLVMBuildFence(LLVMBuilderRef B, @Cast("LLVMAtomicOrdering") int ordering,
                            @Cast("LLVMBool") int singleThread, String Name);
public static native LLVMValueRef LLVMBuildAtomicRMW(LLVMBuilderRef B, @Cast("LLVMAtomicRMWBinOp") int op,
                                LLVMValueRef PTR, LLVMValueRef Val,
                                @Cast("LLVMAtomicOrdering") int ordering,
                                @Cast("LLVMBool") int singleThread);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreModuleProvider Module Providers
 *
 * @{
 */

/**
 * Changes the type of M so it can be passed to FunctionPassManagers and the
 * JIT.  They take ModuleProviders for historical reasons.
 */
public static native LLVMModuleProviderRef LLVMCreateModuleProviderForExistingModule(LLVMModuleRef M);

/**
 * Destroys the module M.
 */
public static native void LLVMDisposeModuleProvider(LLVMModuleProviderRef M);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreMemoryBuffers Memory Buffers
 *
 * @{
 */

public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(@Cast("const char*") BytePointer Path,
                                                  @ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                                  @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(@Cast("const char*") BytePointer Path,
                                                  @ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                                  @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(String Path,
                                                  @Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf,
                                                  @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(@Cast("const char*") BytePointer Path,
                                                  @ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                                  @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(String Path,
                                                  @Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf,
                                                  @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(@Cast("const char*") BytePointer Path,
                                                  @ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                                  @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithContentsOfFile(String Path,
                                                  @Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf,
                                                  @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                         @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                         @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf,
                                         @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                         @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf,
                                         @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@ByPtrPtr LLVMMemoryBufferRef OutMemBuf,
                                         @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMCreateMemoryBufferWithSTDIN(@Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf,
                                         @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native LLVMMemoryBufferRef LLVMCreateMemoryBufferWithMemoryRange(@Cast("const char*") BytePointer InputData,
                                                          @Cast("size_t") long InputDataLength,
                                                          @Cast("const char*") BytePointer BufferName,
                                                          @Cast("LLVMBool") int RequiresNullTerminator);
public static native LLVMMemoryBufferRef LLVMCreateMemoryBufferWithMemoryRange(String InputData,
                                                          @Cast("size_t") long InputDataLength,
                                                          String BufferName,
                                                          @Cast("LLVMBool") int RequiresNullTerminator);
public static native LLVMMemoryBufferRef LLVMCreateMemoryBufferWithMemoryRangeCopy(@Cast("const char*") BytePointer InputData,
                                                              @Cast("size_t") long InputDataLength,
                                                              @Cast("const char*") BytePointer BufferName);
public static native LLVMMemoryBufferRef LLVMCreateMemoryBufferWithMemoryRangeCopy(String InputData,
                                                              @Cast("size_t") long InputDataLength,
                                                              String BufferName);
public static native @Cast("const char*") BytePointer LLVMGetBufferStart(LLVMMemoryBufferRef MemBuf);
public static native @Cast("size_t") long LLVMGetBufferSize(LLVMMemoryBufferRef MemBuf);
public static native void LLVMDisposeMemoryBuffer(LLVMMemoryBufferRef MemBuf);

/**
 * @}
 */

/**
 * @defgroup LLVMCCorePassRegistry Pass Registry
 *
 * @{
 */

/** Return the global pass registry, for use with initialization functions.
    @see llvm::PassRegistry::getPassRegistry */
public static native LLVMPassRegistryRef LLVMGetGlobalPassRegistry();

/**
 * @}
 */

/**
 * @defgroup LLVMCCorePassManagers Pass Managers
 *
 * @{
 */

/** Constructs a new whole-module pass pipeline. This type of pipeline is
    suitable for link-time optimization and whole-module transformations.
    @see llvm::PassManager::PassManager */
public static native LLVMPassManagerRef LLVMCreatePassManager();

/** Constructs a new function-by-function pass pipeline over the module
    provider. It does not take ownership of the module provider. This type of
    pipeline is suitable for code generation and JIT compilation tasks.
    @see llvm::FunctionPassManager::FunctionPassManager */
public static native LLVMPassManagerRef LLVMCreateFunctionPassManagerForModule(LLVMModuleRef M);

/** Deprecated: Use LLVMCreateFunctionPassManagerForModule instead. */
public static native LLVMPassManagerRef LLVMCreateFunctionPassManager(LLVMModuleProviderRef MP);

/** Initializes, executes on the provided module, and finalizes all of the
    passes scheduled in the pass manager. Returns 1 if any of the passes
    modified the module, 0 otherwise.
    @see llvm::PassManager::run(Module&) */
public static native @Cast("LLVMBool") int LLVMRunPassManager(LLVMPassManagerRef PM, LLVMModuleRef M);

/** Initializes all of the function passes scheduled in the function pass
    manager. Returns 1 if any of the passes modified the module, 0 otherwise.
    @see llvm::FunctionPassManager::doInitialization */
public static native @Cast("LLVMBool") int LLVMInitializeFunctionPassManager(LLVMPassManagerRef FPM);

/** Executes all of the function passes scheduled in the function pass manager
    on the provided function. Returns 1 if any of the passes modified the
    function, false otherwise.
    @see llvm::FunctionPassManager::run(Function&) */
public static native @Cast("LLVMBool") int LLVMRunFunctionPassManager(LLVMPassManagerRef FPM, LLVMValueRef F);

/** Finalizes all of the function passes scheduled in in the function pass
    manager. Returns 1 if any of the passes modified the module, 0 otherwise.
    @see llvm::FunctionPassManager::doFinalization */
public static native @Cast("LLVMBool") int LLVMFinalizeFunctionPassManager(LLVMPassManagerRef FPM);

/** Frees the memory of a pass pipeline. For function pipelines, does not free
    the module provider.
    @see llvm::PassManagerBase::~PassManagerBase. */
public static native void LLVMDisposePassManager(LLVMPassManagerRef PM);

/**
 * @}
 */

/**
 * @defgroup LLVMCCoreThreading Threading
 *
 * Handle the structures needed to make LLVM safe for multithreading.
 *
 * @{
 */

/** Deprecated: Multi-threading can only be enabled/disabled with the compile
    time define LLVM_ENABLE_THREADS.  This function always returns
    LLVMIsMultithreaded(). */
public static native @Cast("LLVMBool") int LLVMStartMultithreaded();

/** Deprecated: Multi-threading can only be enabled/disabled with the compile
    time define LLVM_ENABLE_THREADS. */
public static native void LLVMStopMultithreaded();

/** Check whether LLVM is executing in thread-safe mode or not.
    @see llvm::llvm_is_multithreaded */
public static native @Cast("LLVMBool") int LLVMIsMultithreaded();

/**
 * @}
 */

/**
 * @}
 */

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* !defined(__cplusplus) */

// #endif /* !defined(LLVM_C_CORE_H) */


// Parsed from <llvm-c/Analysis.h>

/*===-- llvm-c/Analysis.h - Analysis Library C Interface --------*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMAnalysis.a, which           *|
|* implements various analyses of the LLVM IR.                                *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_ANALYSIS_H
// #define LLVM_C_ANALYSIS_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCAnalysis Analysis
 * @ingroup LLVMC
 *
 * @{
 */

/** enum LLVMVerifierFailureAction */
public static final int
  LLVMAbortProcessAction = 0, /* verifier will print to stderr and abort() */
  LLVMPrintMessageAction = 1, /* verifier will print to stderr and return 1 */
  LLVMReturnStatusAction = 2;  /* verifier will just return 1 */


/* Verifies that a module is valid, taking the specified action if not.
   Optionally returns a human-readable description of any invalid constructs.
   OutMessage must be disposed with LLVMDisposeMessage. */
public static native @Cast("LLVMBool") int LLVMVerifyModule(LLVMModuleRef M, @Cast("LLVMVerifierFailureAction") int Action,
                          @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMVerifyModule(LLVMModuleRef M, @Cast("LLVMVerifierFailureAction") int Action,
                          @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMVerifyModule(LLVMModuleRef M, @Cast("LLVMVerifierFailureAction") int Action,
                          @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMVerifyModule(LLVMModuleRef M, @Cast("LLVMVerifierFailureAction") int Action,
                          @Cast("char**") @ByPtrPtr byte[] OutMessage);

/* Verifies that a single function is valid, taking the specified action. Useful
   for debugging. */
public static native @Cast("LLVMBool") int LLVMVerifyFunction(LLVMValueRef Fn, @Cast("LLVMVerifierFailureAction") int Action);

/* Open up a ghostview window that displays the CFG of the current function.
   Useful for debugging. */
public static native void LLVMViewFunctionCFG(LLVMValueRef Fn);
public static native void LLVMViewFunctionCFGOnly(LLVMValueRef Fn);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/BitReader.h>

/*===-- llvm-c/BitReader.h - BitReader Library C Interface ------*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMBitReader.a, which          *|
|* implements input of the LLVM bitcode format.                               *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_BITREADER_H
// #define LLVM_C_BITREADER_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCBitReader Bit Reader
 * @ingroup LLVMC
 *
 * @{
 */

/* Builds a module from the bitcode in the specified memory buffer, returning a
   reference to the module via the OutModule parameter. Returns 0 on success.
   Optionally returns a human-readable error message via OutMessage. */
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @Cast("LLVMModuleRef*") PointerPointer OutModule, @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @Cast("LLVMModuleRef*") PointerPointer OutModule, @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcode(LLVMMemoryBufferRef MemBuf,
                          @Cast("LLVMModuleRef*") PointerPointer OutModule, @Cast("char**") @ByPtrPtr byte[] OutMessage);

public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @Cast("LLVMModuleRef*") PointerPointer OutModule, @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @Cast("LLVMModuleRef*") PointerPointer OutModule, @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @ByPtrPtr LLVMModuleRef OutModule, @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseBitcodeInContext(LLVMContextRef ContextRef,
                                   LLVMMemoryBufferRef MemBuf,
                                   @Cast("LLVMModuleRef*") PointerPointer OutModule, @Cast("char**") @ByPtrPtr byte[] OutMessage);

/** Reads a module from the specified path, returning via the OutMP parameter
    a module provider which performs lazy deserialization. Returns 0 on success.
    Optionally returns a human-readable error message via OutMessage. */
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @ByPtrPtr LLVMModuleRef OutM,
                                       @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @ByPtrPtr LLVMModuleRef OutM,
                                       @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @Cast("LLVMModuleRef*") PointerPointer OutM,
                                       @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @ByPtrPtr LLVMModuleRef OutM,
                                       @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @Cast("LLVMModuleRef*") PointerPointer OutM,
                                       @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @ByPtrPtr LLVMModuleRef OutM,
                                       @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleInContext(LLVMContextRef ContextRef,
                                       LLVMMemoryBufferRef MemBuf,
                                       @Cast("LLVMModuleRef*") PointerPointer OutM,
                                       @Cast("char**") @ByPtrPtr byte[] OutMessage);

public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @Cast("LLVMModuleRef*") PointerPointer OutM,
                              @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @Cast("LLVMModuleRef*") PointerPointer OutM,
                              @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModule(LLVMMemoryBufferRef MemBuf, @Cast("LLVMModuleRef*") PointerPointer OutM,
                              @Cast("char**") @ByPtrPtr byte[] OutMessage);


/** Deprecated: Use LLVMGetBitcodeModuleInContext instead. */
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @ByPtrPtr LLVMModuleProviderRef OutMP,
                                               @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @ByPtrPtr LLVMModuleProviderRef OutMP,
                                               @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @Cast("LLVMModuleProviderRef*") PointerPointer OutMP,
                                               @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @ByPtrPtr LLVMModuleProviderRef OutMP,
                                               @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @Cast("LLVMModuleProviderRef*") PointerPointer OutMP,
                                               @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @ByPtrPtr LLVMModuleProviderRef OutMP,
                                               @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProviderInContext(LLVMContextRef ContextRef,
                                               LLVMMemoryBufferRef MemBuf,
                                               @Cast("LLVMModuleProviderRef*") PointerPointer OutMP,
                                               @Cast("char**") @ByPtrPtr byte[] OutMessage);

/** Deprecated: Use LLVMGetBitcodeModule instead. */
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @ByPtrPtr LLVMModuleProviderRef OutMP,
                                      @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @ByPtrPtr LLVMModuleProviderRef OutMP,
                                      @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @Cast("LLVMModuleProviderRef*") PointerPointer OutMP,
                                      @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @ByPtrPtr LLVMModuleProviderRef OutMP,
                                      @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @Cast("LLVMModuleProviderRef*") PointerPointer OutMP,
                                      @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @ByPtrPtr LLVMModuleProviderRef OutMP,
                                      @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMGetBitcodeModuleProvider(LLVMMemoryBufferRef MemBuf,
                                      @Cast("LLVMModuleProviderRef*") PointerPointer OutMP,
                                      @Cast("char**") @ByPtrPtr byte[] OutMessage);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/BitWriter.h>

/*===-- llvm-c/BitWriter.h - BitWriter Library C Interface ------*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMBitWriter.a, which          *|
|* implements output of the LLVM bitcode format.                              *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_BITWRITER_H
// #define LLVM_C_BITWRITER_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCBitWriter Bit Writer
 * @ingroup LLVMC
 *
 * @{
 */

/*===-- Operations on modules ---------------------------------------------===*/

/** Writes a module to the specified path. Returns 0 on success. */
public static native int LLVMWriteBitcodeToFile(LLVMModuleRef M, @Cast("const char*") BytePointer Path);
public static native int LLVMWriteBitcodeToFile(LLVMModuleRef M, String Path);

/** Writes a module to an open file descriptor. Returns 0 on success. */
public static native int LLVMWriteBitcodeToFD(LLVMModuleRef M, int FD, int ShouldClose,
                         int Unbuffered);

/** Deprecated for LLVMWriteBitcodeToFD. Writes a module to an open file
    descriptor. Returns 0 on success. Closes the Handle. */
public static native int LLVMWriteBitcodeToFileHandle(LLVMModuleRef M, int Handle);

/** Writes a module to a new memory buffer and returns it. */
public static native LLVMMemoryBufferRef LLVMWriteBitcodeToMemoryBuffer(LLVMModuleRef M);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/Disassembler.h>

/*===-- llvm-c/Disassembler.h - Disassembler Public C Interface ---*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header provides a public interface to a disassembler library.         *|
|* LLVM provides an implementation of this interface.                         *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_DISASSEMBLER_H
// #define LLVM_C_DISASSEMBLER_H

// #include "llvm/Support/DataTypes.h"
// #include <stddef.h>

/**
 * @defgroup LLVMCDisassembler Disassembler
 * @ingroup LLVMC
 *
 * @{
 */

/**
 * An opaque reference to a disassembler context.
 */
@Namespace @Name("void") @Opaque public static class LLVMDisasmContextRef extends Pointer {
    /** Empty constructor. */
    public LLVMDisasmContextRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMDisasmContextRef(Pointer p) { super(p); }
}

/**
 * The type for the operand information call back function.  This is called to
 * get the symbolic information for an operand of an instruction.  Typically
 * this is from the relocation information, symbol table, etc.  That block of
 * information is saved when the disassembler context is created and passed to
 * the call back in the DisInfo parameter.  The instruction containing operand
 * is at the PC parameter.  For some instruction sets, there can be more than
 * one operand with symbolic information.  To determine the symbolic operand
 * information for each operand, the bytes for the specific operand in the
 * instruction are specified by the Offset parameter and its byte widith is the
 * size parameter.  For instructions sets with fixed widths and one symbolic
 * operand per instruction, the Offset parameter will be zero and Size parameter
 * will be the instruction width.  The information is returned in TagBuf and is
 * Triple specific with its specific information defined by the value of
 * TagType for that Triple.  If symbolic information is returned the function
 * returns 1, otherwise it returns 0.
 */
public static class LLVMOpInfoCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMOpInfoCallback(Pointer p) { super(p); }
    protected LLVMOpInfoCallback() { allocate(); }
    private native void allocate();
    public native int call(Pointer DisInfo, @Cast("uint64_t") long PC,
                                  @Cast("uint64_t") long Offset, @Cast("uint64_t") long Size,
                                  int TagType, Pointer TagBuf);
}

/**
 * The initial support in LLVM MC for the most general form of a relocatable
 * expression is "AddSymbol - SubtractSymbol + Offset".  For some Darwin targets
 * this full form is encoded in the relocation information so that AddSymbol and
 * SubtractSymbol can be link edited independent of each other.  Many other
 * platforms only allow a relocatable expression of the form AddSymbol + Offset
 * to be encoded.
 *
 * The LLVMOpInfoCallback() for the TagType value of 1 uses the struct
 * LLVMOpInfo1.  The value of the relocatable expression for the operand,
 * including any PC adjustment, is passed in to the call back in the Value
 * field.  The symbolic information about the operand is returned using all
 * the fields of the structure with the Offset of the relocatable expression
 * returned in the Value field.  It is possible that some symbols in the
 * relocatable expression were assembly temporary symbols, for example
 * "Ldata - LpicBase + constant", and only the Values of the symbols without
 * symbol names are present in the relocation information.  The VariantKind
 * type is one of the Target specific #defines below and is used to print
 * operands like "_foo@GOT", ":lower16:_foo", etc.
 */
public static class LLVMOpInfoSymbol1 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public LLVMOpInfoSymbol1() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public LLVMOpInfoSymbol1(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMOpInfoSymbol1(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public LLVMOpInfoSymbol1 position(int position) {
        return (LLVMOpInfoSymbol1)super.position(position);
    }

  public native @Cast("uint64_t") long Present(); public native LLVMOpInfoSymbol1 Present(long Present);  /* 1 if this symbol is present */
  @MemberGetter public native @Cast("const char*") BytePointer Name();  /* symbol name if not NULL */
  public native @Cast("uint64_t") long Value(); public native LLVMOpInfoSymbol1 Value(long Value);    /* symbol value if name is NULL */
}

public static class LLVMOpInfo1 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public LLVMOpInfo1() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public LLVMOpInfo1(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMOpInfo1(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public LLVMOpInfo1 position(int position) {
        return (LLVMOpInfo1)super.position(position);
    }

  public native @ByRef LLVMOpInfoSymbol1 AddSymbol(); public native LLVMOpInfo1 AddSymbol(LLVMOpInfoSymbol1 AddSymbol);
  public native @ByRef LLVMOpInfoSymbol1 SubtractSymbol(); public native LLVMOpInfo1 SubtractSymbol(LLVMOpInfoSymbol1 SubtractSymbol);
  public native @Cast("uint64_t") long Value(); public native LLVMOpInfo1 Value(long Value);
  public native @Cast("uint64_t") long VariantKind(); public native LLVMOpInfo1 VariantKind(long VariantKind);
}

/**
 * The operand VariantKinds for symbolic disassembly.
 */
public static final int LLVMDisassembler_VariantKind_None = 0; /* all targets */

/**
 * The ARM target VariantKinds.
 */
public static final int LLVMDisassembler_VariantKind_ARM_HI16 = 1; /* :upper16: */
public static final int LLVMDisassembler_VariantKind_ARM_LO16 = 2; /* :lower16: */

/**
 * The ARM64 target VariantKinds.
 */
public static final int LLVMDisassembler_VariantKind_ARM64_PAGE =       1; /* @page */
public static final int LLVMDisassembler_VariantKind_ARM64_PAGEOFF =    2; /* @pageoff */
public static final int LLVMDisassembler_VariantKind_ARM64_GOTPAGE =    3; /* @gotpage */
public static final int LLVMDisassembler_VariantKind_ARM64_GOTPAGEOFF = 4; /* @gotpageoff */
public static final int LLVMDisassembler_VariantKind_ARM64_TLVP =       5; /* @tvlppage */
public static final int LLVMDisassembler_VariantKind_ARM64_TLVOFF =     6; /* @tvlppageoff */

/**
 * The type for the symbol lookup function.  This may be called by the
 * disassembler for things like adding a comment for a PC plus a constant
 * offset load instruction to use a symbol name instead of a load address value.
 * It is passed the block information is saved when the disassembler context is
 * created and the ReferenceValue to look up as a symbol.  If no symbol is found
 * for the ReferenceValue NULL is returned.  The ReferenceType of the
 * instruction is passed indirectly as is the PC of the instruction in
 * ReferencePC.  If the output reference can be determined its type is returned
 * indirectly in ReferenceType along with ReferenceName if any, or that is set
 * to NULL.
 */
public static class LLVMSymbolLookupCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMSymbolLookupCallback(Pointer p) { super(p); }
    protected LLVMSymbolLookupCallback() { allocate(); }
    private native void allocate();
    public native @Cast("const char*") BytePointer call(Pointer DisInfo,
                                                @Cast("uint64_t") long ReferenceValue,
                                                @Cast("uint64_t*") LongPointer ReferenceType,
                                                @Cast("uint64_t") long ReferencePC,
                                                @Cast("const char**") @ByPtrPtr BytePointer ReferenceName);
}
/**
 * The reference types on input and output.
 */
/* No input reference type or no output reference type. */
public static final int LLVMDisassembler_ReferenceType_InOut_None = 0;

/* The input reference is from a branch instruction. */
public static final int LLVMDisassembler_ReferenceType_In_Branch = 1;
/* The input reference is from a PC relative load instruction. */
public static final int LLVMDisassembler_ReferenceType_In_PCrel_Load = 2;

/* The input reference is from an ARM64::ADRP instruction. */
public static final long LLVMDisassembler_ReferenceType_In_ARM64_ADRP = 0x100000001L;
/* The input reference is from an ARM64::ADDXri instruction. */
public static final long LLVMDisassembler_ReferenceType_In_ARM64_ADDXri = 0x100000002L;
/* The input reference is from an ARM64::LDRXui instruction. */
public static final long LLVMDisassembler_ReferenceType_In_ARM64_LDRXui = 0x100000003L;
/* The input reference is from an ARM64::LDRXl instruction. */
public static final long LLVMDisassembler_ReferenceType_In_ARM64_LDRXl = 0x100000004L;
/* The input reference is from an ARM64::ADR instruction. */
public static final long LLVMDisassembler_ReferenceType_In_ARM64_ADR = 0x100000005L;

/* The output reference is to as symbol stub. */
public static final int LLVMDisassembler_ReferenceType_Out_SymbolStub = 1;
/* The output reference is to a symbol address in a literal pool. */
public static final int LLVMDisassembler_ReferenceType_Out_LitPool_SymAddr = 2;
/* The output reference is to a cstring address in a literal pool. */
public static final int LLVMDisassembler_ReferenceType_Out_LitPool_CstrAddr = 3;

/* The output reference is to a Objective-C CoreFoundation string. */
public static final int LLVMDisassembler_ReferenceType_Out_Objc_CFString_Ref = 4;
/* The output reference is to a Objective-C message. */
public static final int LLVMDisassembler_ReferenceType_Out_Objc_Message = 5;
/* The output reference is to a Objective-C message ref. */
public static final int LLVMDisassembler_ReferenceType_Out_Objc_Message_Ref = 6;
/* The output reference is to a Objective-C selector ref. */
public static final int LLVMDisassembler_ReferenceType_Out_Objc_Selector_Ref = 7;
/* The output reference is to a Objective-C class ref. */
public static final int LLVMDisassembler_ReferenceType_Out_Objc_Class_Ref = 8;

/* The output reference is to a C++ symbol name. */
public static final int LLVMDisassembler_ReferenceType_DeMangled_Name = 9;

// #ifdef __cplusplus
// #endif /* !defined(__cplusplus) */

/**
 * Create a disassembler for the TripleName.  Symbolic disassembly is supported
 * by passing a block of information in the DisInfo parameter and specifying the
 * TagType and callback functions as described above.  These can all be passed
 * as NULL.  If successful, this returns a disassembler context.  If not, it
 * returns NULL. This function is equivalent to calling
 * LLVMCreateDisasmCPUFeatures() with an empty CPU name and feature set.
 */
public static native LLVMDisasmContextRef LLVMCreateDisasm(@Cast("const char*") BytePointer TripleName, Pointer DisInfo,
                                      int TagType, LLVMOpInfoCallback GetOpInfo,
                                      LLVMSymbolLookupCallback SymbolLookUp);
public static native LLVMDisasmContextRef LLVMCreateDisasm(String TripleName, Pointer DisInfo,
                                      int TagType, LLVMOpInfoCallback GetOpInfo,
                                      LLVMSymbolLookupCallback SymbolLookUp);

/**
 * Create a disassembler for the TripleName and a specific CPU.  Symbolic
 * disassembly is supported by passing a block of information in the DisInfo
 * parameter and specifying the TagType and callback functions as described
 * above.  These can all be passed * as NULL.  If successful, this returns a
 * disassembler context.  If not, it returns NULL. This function is equivalent
 * to calling LLVMCreateDisasmCPUFeatures() with an empty feature set.
 */
public static native LLVMDisasmContextRef LLVMCreateDisasmCPU(@Cast("const char*") BytePointer Triple, @Cast("const char*") BytePointer CPU,
                                         Pointer DisInfo, int TagType,
                                         LLVMOpInfoCallback GetOpInfo,
                                         LLVMSymbolLookupCallback SymbolLookUp);
public static native LLVMDisasmContextRef LLVMCreateDisasmCPU(String Triple, String CPU,
                                         Pointer DisInfo, int TagType,
                                         LLVMOpInfoCallback GetOpInfo,
                                         LLVMSymbolLookupCallback SymbolLookUp);

/**
 * Create a disassembler for the TripleName, a specific CPU and specific feature
 * string.  Symbolic disassembly is supported by passing a block of information
 * in the DisInfo parameter and specifying the TagType and callback functions as
 * described above.  These can all be passed * as NULL.  If successful, this
 * returns a disassembler context.  If not, it returns NULL.
 */
public static native LLVMDisasmContextRef LLVMCreateDisasmCPUFeatures(@Cast("const char*") BytePointer Triple, @Cast("const char*") BytePointer CPU,
                            @Cast("const char*") BytePointer Features, Pointer DisInfo, int TagType,
                            LLVMOpInfoCallback GetOpInfo,
                            LLVMSymbolLookupCallback SymbolLookUp);
public static native LLVMDisasmContextRef LLVMCreateDisasmCPUFeatures(String Triple, String CPU,
                            String Features, Pointer DisInfo, int TagType,
                            LLVMOpInfoCallback GetOpInfo,
                            LLVMSymbolLookupCallback SymbolLookUp);

/**
 * Set the disassembler's options.  Returns 1 if it can set the Options and 0
 * otherwise.
 */
public static native int LLVMSetDisasmOptions(LLVMDisasmContextRef DC, @Cast("uint64_t") long Options);

/* The option to produce marked up assembly. */
public static final int LLVMDisassembler_Option_UseMarkup = 1;
/* The option to print immediates as hex. */
public static final int LLVMDisassembler_Option_PrintImmHex = 2;
/* The option use the other assembler printer variant */
public static final int LLVMDisassembler_Option_AsmPrinterVariant = 4;
/* The option to set comment on instructions */
public static final int LLVMDisassembler_Option_SetInstrComments = 8;
  /* The option to print latency information alongside instructions */
public static final int LLVMDisassembler_Option_PrintLatency = 16;

/**
 * Dispose of a disassembler context.
 */
public static native void LLVMDisasmDispose(LLVMDisasmContextRef DC);

/**
 * Disassemble a single instruction using the disassembler context specified in
 * the parameter DC.  The bytes of the instruction are specified in the
 * parameter Bytes, and contains at least BytesSize number of bytes.  The
 * instruction is at the address specified by the PC parameter.  If a valid
 * instruction can be disassembled, its string is returned indirectly in
 * OutString whose size is specified in the parameter OutStringSize.  This
 * function returns the number of bytes in the instruction or zero if there was
 * no valid instruction.
 */
public static native @Cast("size_t") long LLVMDisasmInstruction(LLVMDisasmContextRef DC, @Cast("uint8_t*") BytePointer Bytes,
                             @Cast("uint64_t") long BytesSize, @Cast("uint64_t") long PC,
                             @Cast("char*") BytePointer OutString, @Cast("size_t") long OutStringSize);
public static native @Cast("size_t") long LLVMDisasmInstruction(LLVMDisasmContextRef DC, @Cast("uint8_t*") ByteBuffer Bytes,
                             @Cast("uint64_t") long BytesSize, @Cast("uint64_t") long PC,
                             @Cast("char*") ByteBuffer OutString, @Cast("size_t") long OutStringSize);
public static native @Cast("size_t") long LLVMDisasmInstruction(LLVMDisasmContextRef DC, @Cast("uint8_t*") byte[] Bytes,
                             @Cast("uint64_t") long BytesSize, @Cast("uint64_t") long PC,
                             @Cast("char*") byte[] OutString, @Cast("size_t") long OutStringSize);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* !defined(__cplusplus) */

// #endif /* !defined(LLVM_C_DISASSEMBLER_H) */


// Parsed from <llvm-c/Initialization.h>

/*===-- llvm-c/Initialization.h - Initialization C Interface ------*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to LLVM initialization routines,      *|
|* which must be called before you can use the functionality provided by      *|
|* the corresponding LLVM library.                                            *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_INITIALIZATION_H
// #define LLVM_C_INITIALIZATION_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCInitialization Initialization Routines
 * @ingroup LLVMC
 *
 * This module contains routines used to initialize the LLVM system.
 *
 * @{
 */
public static native void LLVMInitializeTransformUtils(LLVMPassRegistryRef R);
public static native void LLVMInitializeScalarOpts(LLVMPassRegistryRef R);
public static native void LLVMInitializeObjCARCOpts(LLVMPassRegistryRef R);
public static native void LLVMInitializeVectorization(LLVMPassRegistryRef R);
public static native void LLVMInitializeInstCombine(LLVMPassRegistryRef R);
public static native void LLVMInitializeIPO(LLVMPassRegistryRef R);
public static native void LLVMInitializeInstrumentation(LLVMPassRegistryRef R);
public static native void LLVMInitializeAnalysis(LLVMPassRegistryRef R);
public static native void LLVMInitializeIPA(LLVMPassRegistryRef R);
public static native void LLVMInitializeCodeGen(LLVMPassRegistryRef R);
public static native void LLVMInitializeTarget(LLVMPassRegistryRef R);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/IRReader.h>

/*===-- llvm-c/IRReader.h - IR Reader C Interface -----------------*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This file defines the C interface to the IR Reader.                        *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_IRREADER_H
// #define LLVM_C_IRREADER_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * Read LLVM IR from a memory buffer and convert it into an in-memory Module
 * object. Returns 0 on success.
 * Optionally returns a human-readable description of any errors that
 * occurred during parsing IR. OutMessage must be disposed with
 * LLVMDisposeMessage.
 *
 * @see llvm::ParseIR()
 */
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @Cast("LLVMModuleRef*") PointerPointer OutM,
                              @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") @ByPtrPtr byte[] OutMessage);
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @Cast("LLVMModuleRef*") PointerPointer OutM,
                              @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @ByPtrPtr LLVMModuleRef OutM,
                              @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMParseIRInContext(LLVMContextRef ContextRef,
                              LLVMMemoryBufferRef MemBuf, @Cast("LLVMModuleRef*") PointerPointer OutM,
                              @Cast("char**") @ByPtrPtr byte[] OutMessage);

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/Linker.h>

/*===-- llvm-c/Linker.h - Module Linker C Interface -------------*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This file defines the C interface to the module/file/archive linker.       *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_LINKER_H
// #define LLVM_C_LINKER_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/* This enum is provided for backwards-compatibility only. It has no effect. */
/** enum LLVMLinkerMode */
public static final int
  LLVMLinkerDestroySource = 0, /* This is the default behavior. */
  LLVMLinkerPreserveSource_Removed = 1; /* This option has been deprecated and
                                          should not be used. */

/* Links the source module into the destination module, taking ownership
 * of the source module away from the caller. Optionally returns a
 * human-readable description of any errors that occurred in linking.
 * OutMessage must be disposed with LLVMDisposeMessage. The return value
 * is true if an error occurred, false otherwise.
 *
 * Note that the linker mode parameter \p Unused is no longer used, and has
 * no effect. */
public static native @Cast("LLVMBool") int LLVMLinkModules(LLVMModuleRef Dest, LLVMModuleRef Src,
                         @Cast("LLVMLinkerMode") int Unused, @Cast("char**") PointerPointer OutMessage);
public static native @Cast("LLVMBool") int LLVMLinkModules(LLVMModuleRef Dest, LLVMModuleRef Src,
                         @Cast("LLVMLinkerMode") int Unused, @Cast("char**") @ByPtrPtr BytePointer OutMessage);
public static native @Cast("LLVMBool") int LLVMLinkModules(LLVMModuleRef Dest, LLVMModuleRef Src,
                         @Cast("LLVMLinkerMode") int Unused, @Cast("char**") @ByPtrPtr ByteBuffer OutMessage);
public static native @Cast("LLVMBool") int LLVMLinkModules(LLVMModuleRef Dest, LLVMModuleRef Src,
                         @Cast("LLVMLinkerMode") int Unused, @Cast("char**") @ByPtrPtr byte[] OutMessage);

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/LinkTimeOptimizer.h>

//===-- llvm/LinkTimeOptimizer.h - LTO Public C Interface -------*- C++ -*-===//
//
//                     The LLVM Compiler Infrastructure
//
// This file is distributed under the University of Illinois Open Source
// License. See LICENSE.TXT for details.
//
//===----------------------------------------------------------------------===//
//
// This header provides a C API to use the LLVM link time optimization
// library. This is intended to be used by linkers which are C-only in
// their implementation for performing LTO.
//
//===----------------------------------------------------------------------===//

// #ifndef LLVM_C_LINKTIMEOPTIMIZER_H
// #define LLVM_C_LINKTIMEOPTIMIZER_H

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCLinkTimeOptimizer Link Time Optimization
 * @ingroup LLVMC
 *
 * @{
 */

  /** This provides a dummy type for pointers to the LTO object. */
  @Namespace @Name("void") @Opaque public static class llvm_lto_t extends Pointer {
      /** Empty constructor. */
      public llvm_lto_t() { }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public llvm_lto_t(Pointer p) { super(p); }
  }

  /** This provides a C-visible enumerator to manage status codes.
   *  This should map exactly onto the C++ enumerator LTOStatus. */
  /** enum llvm_lto_status_t */
  public static final int
    LLVM_LTO_UNKNOWN = 0,
    LLVM_LTO_OPT_SUCCESS = 1,
    LLVM_LTO_READ_SUCCESS = 2,
    LLVM_LTO_READ_FAILURE = 3,
    LLVM_LTO_WRITE_FAILURE = 4,
    LLVM_LTO_NO_TARGET = 5,
    LLVM_LTO_NO_WORK = 6,
    LLVM_LTO_MODULE_MERGE_FAILURE = 7,
    LLVM_LTO_ASM_FAILURE = 8,

    //  Added C-specific error codes
    LLVM_LTO_NULL_OBJECT = 9;

  /** This provides C interface to initialize link time optimizer. This allows
   *  linker to use dlopen() interface to dynamically load LinkTimeOptimizer.
   *  extern "C" helps, because dlopen() interface uses name to find the symbol. */
  
  

  
  

/**
 * @}
 */

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/lto.h>

/*===-- llvm-c/lto.h - LTO Public C Interface ---------------------*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header provides public interface to an abstract link time optimization*|
|* library.  LLVM provides an implementation of this interface for use with   *|
|* llvm bitcode files.                                                        *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_LTO_H
// #define LLVM_C_LTO_H

// #include <stddef.h>
// #include <sys/types.h>

// #ifndef __cplusplus
// #if !defined(_MSC_VER)
// #include <stdbool.h>
// #else
/* MSVC in particular does not have anything like _Bool or bool in C, but we can
   at least make sure the type is the same size.  The implementation side will
   use C++ bool. */
// #endif
// #else
// #endif

/**
 * @defgroup LLVMCLTO LTO
 * @ingroup LLVMC
 *
 * @{
 */

public static final int LTO_API_VERSION = 17;

/**
 * \since prior to LTO_API_VERSION=3
 */
/** enum lto_symbol_attributes */
public static final int
    LTO_SYMBOL_ALIGNMENT_MASK              =  0x0000001F, /* log2 of alignment */
    LTO_SYMBOL_PERMISSIONS_MASK            =  0x000000E0,
    LTO_SYMBOL_PERMISSIONS_CODE            =  0x000000A0,
    LTO_SYMBOL_PERMISSIONS_DATA            =  0x000000C0,
    LTO_SYMBOL_PERMISSIONS_RODATA          =  0x00000080,
    LTO_SYMBOL_DEFINITION_MASK             =  0x00000700,
    LTO_SYMBOL_DEFINITION_REGULAR          =  0x00000100,
    LTO_SYMBOL_DEFINITION_TENTATIVE        =  0x00000200,
    LTO_SYMBOL_DEFINITION_WEAK             =  0x00000300,
    LTO_SYMBOL_DEFINITION_UNDEFINED        =  0x00000400,
    LTO_SYMBOL_DEFINITION_WEAKUNDEF        =  0x00000500,
    LTO_SYMBOL_SCOPE_MASK                  =  0x00003800,
    LTO_SYMBOL_SCOPE_INTERNAL              =  0x00000800,
    LTO_SYMBOL_SCOPE_HIDDEN                =  0x00001000,
    LTO_SYMBOL_SCOPE_PROTECTED             =  0x00002000,
    LTO_SYMBOL_SCOPE_DEFAULT               =  0x00001800,
    LTO_SYMBOL_SCOPE_DEFAULT_CAN_BE_HIDDEN =  0x00002800,
    LTO_SYMBOL_COMDAT                      =  0x00004000,
    LTO_SYMBOL_ALIAS                       =  0x00008000;

/**
 * \since prior to LTO_API_VERSION=3
 */
/** enum lto_debug_model */
public static final int
    LTO_DEBUG_MODEL_NONE         = 0,
    LTO_DEBUG_MODEL_DWARF        = 1;

/**
 * \since prior to LTO_API_VERSION=3
 */
/** enum lto_codegen_model */
public static final int
    LTO_CODEGEN_PIC_MODEL_STATIC         = 0,
    LTO_CODEGEN_PIC_MODEL_DYNAMIC        = 1,
    LTO_CODEGEN_PIC_MODEL_DYNAMIC_NO_PIC = 2,
    LTO_CODEGEN_PIC_MODEL_DEFAULT        = 3;

/** opaque reference to a loaded object module */
@Name("LLVMOpaqueLTOModule") @Opaque public static class lto_module_t extends Pointer {
    /** Empty constructor. */
    public lto_module_t() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public lto_module_t(Pointer p) { super(p); }
}

/** opaque reference to a code generator */
@Name("LLVMOpaqueLTOCodeGenerator") @Opaque public static class lto_code_gen_t extends Pointer {
    /** Empty constructor. */
    public lto_code_gen_t() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public lto_code_gen_t(Pointer p) { super(p); }
}

// #ifdef __cplusplus
// #endif

/**
 * Returns a printable string.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("const char*") BytePointer lto_get_version();


/**
 * Returns the last error string or NULL if last operation was successful.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("const char*") BytePointer lto_get_error_message();

/**
 * Checks if a file is a loadable object file.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file(@Cast("const char*") BytePointer path);
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file(String path);


/**
 * Checks if a file is a loadable object compiled for requested target.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file_for_target(@Cast("const char*") BytePointer path,
                                     @Cast("const char*") BytePointer target_triple_prefix);
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file_for_target(String path,
                                     String target_triple_prefix);


/**
 * Checks if a buffer is a loadable object file.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file_in_memory(@Const Pointer mem, @Cast("size_t") long length);


/**
 * Checks if a buffer is a loadable object compiled for requested target.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file_in_memory_for_target(@Const Pointer mem, @Cast("size_t") long length,
                                              @Cast("const char*") BytePointer target_triple_prefix);
public static native @Cast("lto_bool_t") boolean lto_module_is_object_file_in_memory_for_target(@Const Pointer mem, @Cast("size_t") long length,
                                              String target_triple_prefix);


/**
 * Loads an object file from disk.
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native lto_module_t lto_module_create(@Cast("const char*") BytePointer path);
public static native lto_module_t lto_module_create(String path);


/**
 * Loads an object file from memory.
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native lto_module_t lto_module_create_from_memory(@Const Pointer mem, @Cast("size_t") long length);

/**
 * Loads an object file from memory with an extra path argument.
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=9
 */
public static native lto_module_t lto_module_create_from_memory_with_path(@Const Pointer mem, @Cast("size_t") long length,
                                        @Cast("const char*") BytePointer path);
public static native lto_module_t lto_module_create_from_memory_with_path(@Const Pointer mem, @Cast("size_t") long length,
                                        String path);

/**
 * \brief Loads an object file in its own context.
 *
 * Loads an object file in its own LLVMContext.  This function call is
 * thread-safe.  However, modules created this way should not be merged into an
 * lto_code_gen_t using \a lto_codegen_add_module().
 *
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=11
 */
public static native lto_module_t lto_module_create_in_local_context(@Const Pointer mem, @Cast("size_t") long length,
                                   @Cast("const char*") BytePointer path);
public static native lto_module_t lto_module_create_in_local_context(@Const Pointer mem, @Cast("size_t") long length,
                                   String path);

/**
 * \brief Loads an object file in the codegen context.
 *
 * Loads an object file into the same context as \c cg.  The module is safe to
 * add using \a lto_codegen_add_module().
 *
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=11
 */
public static native lto_module_t lto_module_create_in_codegen_context(@Const Pointer mem, @Cast("size_t") long length,
                                     @Cast("const char*") BytePointer path, lto_code_gen_t cg);
public static native lto_module_t lto_module_create_in_codegen_context(@Const Pointer mem, @Cast("size_t") long length,
                                     String path, lto_code_gen_t cg);

/**
 * Loads an object file from disk. The seek point of fd is not preserved.
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=5
 */
public static native lto_module_t lto_module_create_from_fd(int fd, @Cast("const char*") BytePointer path, @Cast("size_t") long file_size);
public static native lto_module_t lto_module_create_from_fd(int fd, String path, @Cast("size_t") long file_size);

/**
 * Loads an object file from disk. The seek point of fd is not preserved.
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=5
 */
public static native lto_module_t lto_module_create_from_fd_at_offset(int fd, @Cast("const char*") BytePointer path, @Cast("size_t") long file_size,
                                    @Cast("size_t") long map_size, @Cast("off_t") long offset);
public static native lto_module_t lto_module_create_from_fd_at_offset(int fd, String path, @Cast("size_t") long file_size,
                                    @Cast("size_t") long map_size, @Cast("off_t") long offset);

/**
 * Frees all memory internally allocated by the module.
 * Upon return the lto_module_t is no longer valid.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native void lto_module_dispose(lto_module_t mod);

/**
 * Returns triple string which the object module was compiled under.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("const char*") BytePointer lto_module_get_target_triple(lto_module_t mod);

/**
 * Sets triple string with which the object will be codegened.
 *
 * \since LTO_API_VERSION=4
 */
public static native void lto_module_set_target_triple(lto_module_t mod, @Cast("const char*") BytePointer triple);
public static native void lto_module_set_target_triple(lto_module_t mod, String triple);


/**
 * Returns the number of symbols in the object module.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("unsigned int") int lto_module_get_num_symbols(lto_module_t mod);


/**
 * Returns the name of the ith symbol in the object module.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("const char*") BytePointer lto_module_get_symbol_name(lto_module_t mod, @Cast("unsigned int") int index);


/**
 * Returns the attributes of the ith symbol in the object module.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_symbol_attributes") int lto_module_get_symbol_attribute(lto_module_t mod, @Cast("unsigned int") int index);


/**
 * Returns the module's linker options.
 *
 * The linker options may consist of multiple flags. It is the linker's
 * responsibility to split the flags using a platform-specific mechanism.
 *
 * \since LTO_API_VERSION=16
 */
public static native @Cast("const char*") BytePointer lto_module_get_linkeropts(lto_module_t mod);


/**
 * Diagnostic severity.
 *
 * \since LTO_API_VERSION=7
 */
/** enum lto_codegen_diagnostic_severity_t */
public static final int
  LTO_DS_ERROR = 0,
  LTO_DS_WARNING = 1,
  LTO_DS_REMARK = 3, // Added in LTO_API_VERSION=10.
  LTO_DS_NOTE = 2;

/**
 * Diagnostic handler type.
 * \p severity defines the severity.
 * \p diag is the actual diagnostic.
 * The diagnostic is not prefixed by any of severity keyword, e.g., 'error: '.
 * \p ctxt is used to pass the context set with the diagnostic handler.
 *
 * \since LTO_API_VERSION=7
 */
public static class lto_diagnostic_handler_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    lto_diagnostic_handler_t(Pointer p) { super(p); }
    protected lto_diagnostic_handler_t() { allocate(); }
    private native void allocate();
    public native void call(
    @Cast("lto_codegen_diagnostic_severity_t") int severity, @Cast("const char*") BytePointer diag, Pointer ctxt);
}

/**
 * Set a diagnostic handler and the related context (void *).
 * This is more general than lto_get_error_message, as the diagnostic handler
 * can be called at anytime within lto.
 *
 * \since LTO_API_VERSION=7
 */
public static native void lto_codegen_set_diagnostic_handler(lto_code_gen_t arg0,
                                               lto_diagnostic_handler_t arg1,
                                               Pointer arg2);

/**
 * Instantiates a code generator.
 * Returns NULL on error (check lto_get_error_message() for details).
 *
 * All modules added using \a lto_codegen_add_module() must have been created
 * in the same context as the codegen.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native lto_code_gen_t lto_codegen_create();

/**
 * \brief Instantiate a code generator in its own context.
 *
 * Instantiates a code generator in its own context.  Modules added via \a
 * lto_codegen_add_module() must have all been created in the same context,
 * using \a lto_module_create_in_codegen_context().
 *
 * \since LTO_API_VERSION=11
 */
public static native lto_code_gen_t lto_codegen_create_in_local_context();

/**
 * Frees all code generator and all memory it internally allocated.
 * Upon return the lto_code_gen_t is no longer valid.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native void lto_codegen_dispose(lto_code_gen_t arg0);

/**
 * Add an object module to the set of modules for which code will be generated.
 * Returns true on error (check lto_get_error_message() for details).
 *
 * \c cg and \c mod must both be in the same context.  See \a
 * lto_codegen_create_in_local_context() and \a
 * lto_module_create_in_codegen_context().
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_codegen_add_module(lto_code_gen_t cg, lto_module_t mod);

/**
 * Sets the object module for code generation. This will transfer the ownship of
 * the module to code generator.
 *
 * \c cg and \c mod must both be in the same context.
 *
 * \since LTO_API_VERSION=13
 */
public static native void lto_codegen_set_module(lto_code_gen_t cg, lto_module_t mod);

/**
 * Sets if debug info should be generated.
 * Returns true on error (check lto_get_error_message() for details).
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_codegen_set_debug_model(lto_code_gen_t cg, @Cast("lto_debug_model") int arg1);


/**
 * Sets which PIC code model to generated.
 * Returns true on error (check lto_get_error_message() for details).
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Cast("lto_bool_t") boolean lto_codegen_set_pic_model(lto_code_gen_t cg, @Cast("lto_codegen_model") int arg1);


/**
 * Sets the cpu to generate code for.
 *
 * \since LTO_API_VERSION=4
 */
public static native void lto_codegen_set_cpu(lto_code_gen_t cg, @Cast("const char*") BytePointer cpu);
public static native void lto_codegen_set_cpu(lto_code_gen_t cg, String cpu);


/**
 * Sets the location of the assembler tool to run. If not set, libLTO
 * will use gcc to invoke the assembler.
 *
 * \since LTO_API_VERSION=3
 */
public static native void lto_codegen_set_assembler_path(lto_code_gen_t cg, @Cast("const char*") BytePointer path);
public static native void lto_codegen_set_assembler_path(lto_code_gen_t cg, String path);

/**
 * Sets extra arguments that libLTO should pass to the assembler.
 *
 * \since LTO_API_VERSION=4
 */
public static native void lto_codegen_set_assembler_args(lto_code_gen_t cg, @Cast("const char**") PointerPointer args,
                               int nargs);
public static native void lto_codegen_set_assembler_args(lto_code_gen_t cg, @Cast("const char**") @ByPtrPtr BytePointer args,
                               int nargs);
public static native void lto_codegen_set_assembler_args(lto_code_gen_t cg, @Cast("const char**") @ByPtrPtr ByteBuffer args,
                               int nargs);
public static native void lto_codegen_set_assembler_args(lto_code_gen_t cg, @Cast("const char**") @ByPtrPtr byte[] args,
                               int nargs);

/**
 * Adds to a list of all global symbols that must exist in the final generated
 * code. If a function is not listed there, it might be inlined into every usage
 * and optimized away.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native void lto_codegen_add_must_preserve_symbol(lto_code_gen_t cg, @Cast("const char*") BytePointer symbol);
public static native void lto_codegen_add_must_preserve_symbol(lto_code_gen_t cg, String symbol);

/**
 * Writes a new object file at the specified path that contains the
 * merged contents of all modules added so far.
 * Returns true on error (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=5
 */
public static native @Cast("lto_bool_t") boolean lto_codegen_write_merged_modules(lto_code_gen_t cg, @Cast("const char*") BytePointer path);
public static native @Cast("lto_bool_t") boolean lto_codegen_write_merged_modules(lto_code_gen_t cg, String path);

/**
 * Generates code for all added modules into one native object file.
 * This calls lto_codegen_optimize then lto_codegen_compile_optimized.
 *
 * On success returns a pointer to a generated mach-o/ELF buffer and
 * length set to the buffer size.  The buffer is owned by the
 * lto_code_gen_t and will be freed when lto_codegen_dispose()
 * is called, or lto_codegen_compile() is called again.
 * On failure, returns NULL (check lto_get_error_message() for details).
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native @Const Pointer lto_codegen_compile(lto_code_gen_t cg, @Cast("size_t*") SizeTPointer length);

/**
 * Generates code for all added modules into one native object file.
 * This calls lto_codegen_optimize then lto_codegen_compile_optimized (instead
 * of returning a generated mach-o/ELF buffer, it writes to a file).
 *
 * The name of the file is written to name. Returns true on error.
 *
 * \since LTO_API_VERSION=5
 */
public static native @Cast("lto_bool_t") boolean lto_codegen_compile_to_file(lto_code_gen_t cg, @Cast("const char**") PointerPointer name);
public static native @Cast("lto_bool_t") boolean lto_codegen_compile_to_file(lto_code_gen_t cg, @Cast("const char**") @ByPtrPtr BytePointer name);
public static native @Cast("lto_bool_t") boolean lto_codegen_compile_to_file(lto_code_gen_t cg, @Cast("const char**") @ByPtrPtr ByteBuffer name);
public static native @Cast("lto_bool_t") boolean lto_codegen_compile_to_file(lto_code_gen_t cg, @Cast("const char**") @ByPtrPtr byte[] name);

/**
 * Runs optimization for the merged module. Returns true on error.
 *
 * \since LTO_API_VERSION=12
 */
public static native @Cast("lto_bool_t") boolean lto_codegen_optimize(lto_code_gen_t cg);

/**
 * Generates code for the optimized merged module into one native object file.
 * It will not run any IR optimizations on the merged module.
 *
 * On success returns a pointer to a generated mach-o/ELF buffer and length set
 * to the buffer size.  The buffer is owned by the lto_code_gen_t and will be
 * freed when lto_codegen_dispose() is called, or
 * lto_codegen_compile_optimized() is called again. On failure, returns NULL
 * (check lto_get_error_message() for details).
 *
 * \since LTO_API_VERSION=12
 */
public static native @Const Pointer lto_codegen_compile_optimized(lto_code_gen_t cg, @Cast("size_t*") SizeTPointer length);

/**
 * Returns the runtime API version.
 *
 * \since LTO_API_VERSION=12
 */
public static native @Cast("unsigned int") int lto_api_version();

/**
 * Sets options to help debug codegen bugs.
 *
 * \since prior to LTO_API_VERSION=3
 */
public static native void lto_codegen_debug_options(lto_code_gen_t cg, @Cast("const char*") BytePointer arg1);
public static native void lto_codegen_debug_options(lto_code_gen_t cg, String arg1);

/**
 * Initializes LLVM disassemblers.
 * FIXME: This doesn't really belong here.
 *
 * \since LTO_API_VERSION=5
 */
public static native void lto_initialize_disassembler();

/**
 * Sets if we should run internalize pass during optimization and code
 * generation.
 *
 * \since LTO_API_VERSION=14
 */
public static native void lto_codegen_set_should_internalize(lto_code_gen_t cg,
                                   @Cast("lto_bool_t") boolean ShouldInternalize);

/**
 * \brief Set whether to embed uselists in bitcode.
 *
 * Sets whether \a lto_codegen_write_merged_modules() should embed uselists in
 * output bitcode.  This should be turned on for all -save-temps output.
 *
 * \since LTO_API_VERSION=15
 */
public static native void lto_codegen_set_should_embed_uselists(lto_code_gen_t cg,
                                      @Cast("lto_bool_t") boolean ShouldEmbedUselists);

// #ifdef __cplusplus
// #endif

/**
 * @}
 */

// #endif


// Parsed from <llvm-c/Object.h>

/*===-- llvm-c/Object.h - Object Lib C Iface --------------------*- C++ -*-===*/
/*                                                                            */
/*                     The LLVM Compiler Infrastructure                       */
/*                                                                            */
/* This file is distributed under the University of Illinois Open Source      */
/* License. See LICENSE.TXT for details.                                      */
/*                                                                            */
/*===----------------------------------------------------------------------===*/
/*                                                                            */
/* This header declares the C interface to libLLVMObject.a, which             */
/* implements object file reading and writing.                                */
/*                                                                            */
/* Many exotic languages can interoperate with C code but have a harder time  */
/* with C++ due to name mangling. So in addition to C, this interface enables */
/* tools written in such languages.                                           */
/*                                                                            */
/*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_OBJECT_H
// #define LLVM_C_OBJECT_H

// #include "llvm-c/Core.h"
// #include "llvm/Config/llvm-config.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCObject Object file reading and writing
 * @ingroup LLVMC
 *
 * @{
 */

// Opaque type wrappers
@Name("LLVMOpaqueObjectFile") @Opaque public static class LLVMObjectFileRef extends Pointer {
    /** Empty constructor. */
    public LLVMObjectFileRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMObjectFileRef(Pointer p) { super(p); }
}
@Name("LLVMOpaqueSectionIterator") @Opaque public static class LLVMSectionIteratorRef extends Pointer {
    /** Empty constructor. */
    public LLVMSectionIteratorRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMSectionIteratorRef(Pointer p) { super(p); }
}
@Name("LLVMOpaqueSymbolIterator") @Opaque public static class LLVMSymbolIteratorRef extends Pointer {
    /** Empty constructor. */
    public LLVMSymbolIteratorRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMSymbolIteratorRef(Pointer p) { super(p); }
}
@Name("LLVMOpaqueRelocationIterator") @Opaque public static class LLVMRelocationIteratorRef extends Pointer {
    /** Empty constructor. */
    public LLVMRelocationIteratorRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMRelocationIteratorRef(Pointer p) { super(p); }
}

// ObjectFile creation
public static native LLVMObjectFileRef LLVMCreateObjectFile(LLVMMemoryBufferRef MemBuf);
public static native void LLVMDisposeObjectFile(LLVMObjectFileRef ObjectFile);

// ObjectFile Section iterators
public static native LLVMSectionIteratorRef LLVMGetSections(LLVMObjectFileRef ObjectFile);
public static native void LLVMDisposeSectionIterator(LLVMSectionIteratorRef SI);
public static native @Cast("LLVMBool") int LLVMIsSectionIteratorAtEnd(LLVMObjectFileRef ObjectFile,
                                LLVMSectionIteratorRef SI);
public static native void LLVMMoveToNextSection(LLVMSectionIteratorRef SI);
public static native void LLVMMoveToContainingSection(LLVMSectionIteratorRef Sect,
                                 LLVMSymbolIteratorRef Sym);

// ObjectFile Symbol iterators
public static native LLVMSymbolIteratorRef LLVMGetSymbols(LLVMObjectFileRef ObjectFile);
public static native void LLVMDisposeSymbolIterator(LLVMSymbolIteratorRef SI);
public static native @Cast("LLVMBool") int LLVMIsSymbolIteratorAtEnd(LLVMObjectFileRef ObjectFile,
                                LLVMSymbolIteratorRef SI);
public static native void LLVMMoveToNextSymbol(LLVMSymbolIteratorRef SI);

// SectionRef accessors
public static native @Cast("const char*") BytePointer LLVMGetSectionName(LLVMSectionIteratorRef SI);
public static native @Cast("uint64_t") long LLVMGetSectionSize(LLVMSectionIteratorRef SI);
public static native @Cast("const char*") BytePointer LLVMGetSectionContents(LLVMSectionIteratorRef SI);
public static native @Cast("uint64_t") long LLVMGetSectionAddress(LLVMSectionIteratorRef SI);
public static native @Cast("LLVMBool") int LLVMGetSectionContainsSymbol(LLVMSectionIteratorRef SI,
                                 LLVMSymbolIteratorRef Sym);

// Section Relocation iterators
public static native LLVMRelocationIteratorRef LLVMGetRelocations(LLVMSectionIteratorRef Section);
public static native void LLVMDisposeRelocationIterator(LLVMRelocationIteratorRef RI);
public static native @Cast("LLVMBool") int LLVMIsRelocationIteratorAtEnd(LLVMSectionIteratorRef Section,
                                       LLVMRelocationIteratorRef RI);
public static native void LLVMMoveToNextRelocation(LLVMRelocationIteratorRef RI);


// SymbolRef accessors
public static native @Cast("const char*") BytePointer LLVMGetSymbolName(LLVMSymbolIteratorRef SI);
public static native @Cast("uint64_t") long LLVMGetSymbolAddress(LLVMSymbolIteratorRef SI);
public static native @Cast("uint64_t") long LLVMGetSymbolSize(LLVMSymbolIteratorRef SI);

// RelocationRef accessors
public static native @Cast("uint64_t") long LLVMGetRelocationOffset(LLVMRelocationIteratorRef RI);
public static native LLVMSymbolIteratorRef LLVMGetRelocationSymbol(LLVMRelocationIteratorRef RI);
public static native @Cast("uint64_t") long LLVMGetRelocationType(LLVMRelocationIteratorRef RI);
// NOTE: Caller takes ownership of returned string of the two
// following functions.
public static native @Cast("const char*") BytePointer LLVMGetRelocationTypeName(LLVMRelocationIteratorRef RI);
public static native @Cast("const char*") BytePointer LLVMGetRelocationValueString(LLVMRelocationIteratorRef RI);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* defined(__cplusplus) */

// #endif


// Parsed from <llvm-c/Target.h>

/*===-- llvm-c/Target.h - Target Lib C Iface --------------------*- C++ -*-===*/
/*                                                                            */
/*                     The LLVM Compiler Infrastructure                       */
/*                                                                            */
/* This file is distributed under the University of Illinois Open Source      */
/* License. See LICENSE.TXT for details.                                      */
/*                                                                            */
/*===----------------------------------------------------------------------===*/
/*                                                                            */
/* This header declares the C interface to libLLVMTarget.a, which             */
/* implements target information.                                             */
/*                                                                            */
/* Many exotic languages can interoperate with C code but have a harder time  */
/* with C++ due to name mangling. So in addition to C, this interface enables */
/* tools written in such languages.                                           */
/*                                                                            */
/*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_TARGET_H
// #define LLVM_C_TARGET_H

// #include "llvm-c/Core.h"
// #include "llvm/Config/llvm-config.h"

// #if defined(_MSC_VER) && !defined(inline)
// #endif

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCTarget Target information
 * @ingroup LLVMC
 *
 * @{
 */

/** enum LLVMByteOrdering */
public static final int LLVMBigEndian = 0, LLVMLittleEndian = 1;

@Name("LLVMOpaqueTargetData") @Opaque public static class LLVMTargetDataRef extends Pointer {
    /** Empty constructor. */
    public LLVMTargetDataRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMTargetDataRef(Pointer p) { super(p); }
}
@Name("LLVMOpaqueTargetLibraryInfotData") @Opaque public static class LLVMTargetLibraryInfoRef extends Pointer {
    /** Empty constructor. */
    public LLVMTargetLibraryInfoRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMTargetLibraryInfoRef(Pointer p) { super(p); }
}

/* Declare all of the target-initialization functions that are available. */
// #define LLVM_TARGET(TargetName)
//   void LLVMInitialize##TargetName##TargetInfo(void);
// #include "llvm/Config/Targets.def"
// #undef LLVM_TARGET  /* Explicit undef to make SWIG happier */

// #define LLVM_TARGET(TargetName) void LLVMInitialize##TargetName##Target(void);
// #include "llvm/Config/Targets.def"
// #undef LLVM_TARGET  /* Explicit undef to make SWIG happier */

// #define LLVM_TARGET(TargetName)
//   void LLVMInitialize##TargetName##TargetMC(void);
// #include "llvm/Config/Targets.def"
// #undef LLVM_TARGET  /* Explicit undef to make SWIG happier */

/* Declare all of the available assembly printer initialization functions. */
// #define LLVM_ASM_PRINTER(TargetName)
//   void LLVMInitialize##TargetName##AsmPrinter(void);
// #include "llvm/Config/AsmPrinters.def"
// #undef LLVM_ASM_PRINTER  /* Explicit undef to make SWIG happier */

/* Declare all of the available assembly parser initialization functions. */
// #define LLVM_ASM_PARSER(TargetName)
//   void LLVMInitialize##TargetName##AsmParser(void);
// #include "llvm/Config/AsmParsers.def"
// #undef LLVM_ASM_PARSER  /* Explicit undef to make SWIG happier */

/* Declare all of the available disassembler initialization functions. */
// #define LLVM_DISASSEMBLER(TargetName)
//   void LLVMInitialize##TargetName##Disassembler(void);
// #include "llvm/Config/Disassemblers.def"
// #undef LLVM_DISASSEMBLER  /* Explicit undef to make SWIG happier */

/** LLVMInitializeAllTargetInfos - The main program should call this function if
    it wants access to all available targets that LLVM is configured to
    support. */
public static native void LLVMInitializeAllTargetInfos();

/** LLVMInitializeAllTargets - The main program should call this function if it
    wants to link in all available targets that LLVM is configured to
    support. */
public static native void LLVMInitializeAllTargets();

/** LLVMInitializeAllTargetMCs - The main program should call this function if
    it wants access to all available target MC that LLVM is configured to
    support. */
public static native void LLVMInitializeAllTargetMCs();

/** LLVMInitializeAllAsmPrinters - The main program should call this function if
    it wants all asm printers that LLVM is configured to support, to make them
    available via the TargetRegistry. */
public static native void LLVMInitializeAllAsmPrinters();

/** LLVMInitializeAllAsmParsers - The main program should call this function if
    it wants all asm parsers that LLVM is configured to support, to make them
    available via the TargetRegistry. */
public static native void LLVMInitializeAllAsmParsers();

/** LLVMInitializeAllDisassemblers - The main program should call this function
    if it wants all disassemblers that LLVM is configured to support, to make
    them available via the TargetRegistry. */
public static native void LLVMInitializeAllDisassemblers();

/** LLVMInitializeNativeTarget - The main program should call this function to
    initialize the native target corresponding to the host.  This is useful
    for JIT applications to ensure that the target gets linked in correctly. */
public static native @Cast("LLVMBool") int LLVMInitializeNativeTarget();

/** LLVMInitializeNativeTargetAsmParser - The main program should call this
    function to initialize the parser for the native target corresponding to the
    host. */
public static native @Cast("LLVMBool") int LLVMInitializeNativeAsmParser();

/** LLVMInitializeNativeTargetAsmPrinter - The main program should call this
    function to initialize the printer for the native target corresponding to
    the host. */
public static native @Cast("LLVMBool") int LLVMInitializeNativeAsmPrinter();

/** LLVMInitializeNativeTargetDisassembler - The main program should call this
    function to initialize the disassembler for the native target corresponding
    to the host. */
public static native @Cast("LLVMBool") int LLVMInitializeNativeDisassembler();

/*===-- Target Data -------------------------------------------------------===*/

/** Creates target data from a target layout string.
    See the constructor llvm::DataLayout::DataLayout. */
public static native LLVMTargetDataRef LLVMCreateTargetData(@Cast("const char*") BytePointer StringRep);
public static native LLVMTargetDataRef LLVMCreateTargetData(String StringRep);

/** Adds target data information to a pass manager. This does not take ownership
    of the target data.
    See the method llvm::PassManagerBase::add. */
public static native void LLVMAddTargetData(LLVMTargetDataRef TD, LLVMPassManagerRef PM);

/** Adds target library information to a pass manager. This does not take
    ownership of the target library info.
    See the method llvm::PassManagerBase::add. */
public static native void LLVMAddTargetLibraryInfo(LLVMTargetLibraryInfoRef TLI,
                              LLVMPassManagerRef PM);

/** Converts target data to a target layout string. The string must be disposed
    with LLVMDisposeMessage.
    See the constructor llvm::DataLayout::DataLayout. */
public static native @Cast("char*") BytePointer LLVMCopyStringRepOfTargetData(LLVMTargetDataRef TD);

/** Returns the byte order of a target, either LLVMBigEndian or
    LLVMLittleEndian.
    See the method llvm::DataLayout::isLittleEndian. */
public static native @Cast("LLVMByteOrdering") int LLVMByteOrder(LLVMTargetDataRef TD);

/** Returns the pointer size in bytes for a target.
    See the method llvm::DataLayout::getPointerSize. */
public static native @Cast("unsigned") int LLVMPointerSize(LLVMTargetDataRef TD);

/** Returns the pointer size in bytes for a target for a specified
    address space.
    See the method llvm::DataLayout::getPointerSize. */
public static native @Cast("unsigned") int LLVMPointerSizeForAS(LLVMTargetDataRef TD, @Cast("unsigned") int AS);

/** Returns the integer type that is the same size as a pointer on a target.
    See the method llvm::DataLayout::getIntPtrType. */
public static native LLVMTypeRef LLVMIntPtrType(LLVMTargetDataRef TD);

/** Returns the integer type that is the same size as a pointer on a target.
    This version allows the address space to be specified.
    See the method llvm::DataLayout::getIntPtrType. */
public static native LLVMTypeRef LLVMIntPtrTypeForAS(LLVMTargetDataRef TD, @Cast("unsigned") int AS);

/** Returns the integer type that is the same size as a pointer on a target.
    See the method llvm::DataLayout::getIntPtrType. */
public static native LLVMTypeRef LLVMIntPtrTypeInContext(LLVMContextRef C, LLVMTargetDataRef TD);

/** Returns the integer type that is the same size as a pointer on a target.
    This version allows the address space to be specified.
    See the method llvm::DataLayout::getIntPtrType. */
public static native LLVMTypeRef LLVMIntPtrTypeForASInContext(LLVMContextRef C, LLVMTargetDataRef TD,
                                         @Cast("unsigned") int AS);

/** Computes the size of a type in bytes for a target.
    See the method llvm::DataLayout::getTypeSizeInBits. */
public static native @Cast("unsigned long long") long LLVMSizeOfTypeInBits(LLVMTargetDataRef TD, LLVMTypeRef Ty);

/** Computes the storage size of a type in bytes for a target.
    See the method llvm::DataLayout::getTypeStoreSize. */
public static native @Cast("unsigned long long") long LLVMStoreSizeOfType(LLVMTargetDataRef TD, LLVMTypeRef Ty);

/** Computes the ABI size of a type in bytes for a target.
    See the method llvm::DataLayout::getTypeAllocSize. */
public static native @Cast("unsigned long long") long LLVMABISizeOfType(LLVMTargetDataRef TD, LLVMTypeRef Ty);

/** Computes the ABI alignment of a type in bytes for a target.
    See the method llvm::DataLayout::getTypeABISize. */
public static native @Cast("unsigned") int LLVMABIAlignmentOfType(LLVMTargetDataRef TD, LLVMTypeRef Ty);

/** Computes the call frame alignment of a type in bytes for a target.
    See the method llvm::DataLayout::getTypeABISize. */
public static native @Cast("unsigned") int LLVMCallFrameAlignmentOfType(LLVMTargetDataRef TD, LLVMTypeRef Ty);

/** Computes the preferred alignment of a type in bytes for a target.
    See the method llvm::DataLayout::getTypeABISize. */
public static native @Cast("unsigned") int LLVMPreferredAlignmentOfType(LLVMTargetDataRef TD, LLVMTypeRef Ty);

/** Computes the preferred alignment of a global variable in bytes for a target.
    See the method llvm::DataLayout::getPreferredAlignment. */
public static native @Cast("unsigned") int LLVMPreferredAlignmentOfGlobal(LLVMTargetDataRef TD,
                                        LLVMValueRef GlobalVar);

/** Computes the structure element that contains the byte offset for a target.
    See the method llvm::StructLayout::getElementContainingOffset. */
public static native @Cast("unsigned") int LLVMElementAtOffset(LLVMTargetDataRef TD, LLVMTypeRef StructTy,
                             @Cast("unsigned long long") long Offset);

/** Computes the byte offset of the indexed struct element for a target.
    See the method llvm::StructLayout::getElementContainingOffset. */
public static native @Cast("unsigned long long") long LLVMOffsetOfElement(LLVMTargetDataRef TD,
                                       LLVMTypeRef StructTy, @Cast("unsigned") int Element);

/** Deallocates a TargetData.
    See the destructor llvm::DataLayout::~DataLayout. */
public static native void LLVMDisposeTargetData(LLVMTargetDataRef TD);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* defined(__cplusplus) */

// #endif


// Parsed from <llvm-c/TargetMachine.h>

/*===-- llvm-c/TargetMachine.h - Target Machine Library C Interface - C++ -*-=*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to the Target and TargetMachine       *|
|* classes, which can be used to generate assembly or object files.           *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_TARGETMACHINE_H
// #define LLVM_C_TARGETMACHINE_H

// #include "llvm-c/Core.h"
// #include "llvm-c/Target.h"

// #ifdef __cplusplus
// #endif
@Name("LLVMOpaqueTargetMachine") @Opaque public static class LLVMTargetMachineRef extends Pointer {
    /** Empty constructor. */
    public LLVMTargetMachineRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMTargetMachineRef(Pointer p) { super(p); }
}
@Name("LLVMTarget") @Opaque public static class LLVMTargetRef extends Pointer {
    /** Empty constructor. */
    public LLVMTargetRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMTargetRef(Pointer p) { super(p); }
}

/** enum LLVMCodeGenOptLevel */
public static final int
    LLVMCodeGenLevelNone = 0,
    LLVMCodeGenLevelLess = 1,
    LLVMCodeGenLevelDefault = 2,
    LLVMCodeGenLevelAggressive = 3;

/** enum LLVMRelocMode */
public static final int
    LLVMRelocDefault = 0,
    LLVMRelocStatic = 1,
    LLVMRelocPIC = 2,
    LLVMRelocDynamicNoPic = 3;

/** enum LLVMCodeModel */
public static final int
    LLVMCodeModelDefault = 0,
    LLVMCodeModelJITDefault = 1,
    LLVMCodeModelSmall = 2,
    LLVMCodeModelKernel = 3,
    LLVMCodeModelMedium = 4,
    LLVMCodeModelLarge = 5;

/** enum LLVMCodeGenFileType */
public static final int
    LLVMAssemblyFile = 0,
    LLVMObjectFile = 1;

/** Returns the first llvm::Target in the registered targets list. */
public static native LLVMTargetRef LLVMGetFirstTarget();
/** Returns the next llvm::Target given a previous one (or null if there's none) */
public static native LLVMTargetRef LLVMGetNextTarget(LLVMTargetRef T);

/*===-- Target ------------------------------------------------------------===*/
/** Finds the target corresponding to the given name and stores it in \p T.
  Returns 0 on success. */
public static native LLVMTargetRef LLVMGetTargetFromName(@Cast("const char*") BytePointer Name);
public static native LLVMTargetRef LLVMGetTargetFromName(String Name);

/** Finds the target corresponding to the given triple and stores it in \p T.
  Returns 0 on success. Optionally returns any error in ErrorMessage.
  Use LLVMDisposeMessage to dispose the message. */
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(@Cast("const char*") BytePointer Triple, @ByPtrPtr LLVMTargetRef T,
                                 @Cast("char**") PointerPointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(@Cast("const char*") BytePointer Triple, @ByPtrPtr LLVMTargetRef T,
                                 @Cast("char**") @ByPtrPtr BytePointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(String Triple, @Cast("LLVMTargetRef*") PointerPointer T,
                                 @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(@Cast("const char*") BytePointer Triple, @ByPtrPtr LLVMTargetRef T,
                                 @Cast("char**") @ByPtrPtr byte[] ErrorMessage);
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(String Triple, @Cast("LLVMTargetRef*") PointerPointer T,
                                 @Cast("char**") @ByPtrPtr BytePointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(@Cast("const char*") BytePointer Triple, @ByPtrPtr LLVMTargetRef T,
                                 @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMGetTargetFromTriple(String Triple, @Cast("LLVMTargetRef*") PointerPointer T,
                                 @Cast("char**") @ByPtrPtr byte[] ErrorMessage);

/** Returns the name of a target. See llvm::Target::getName */
public static native @Cast("const char*") BytePointer LLVMGetTargetName(LLVMTargetRef T);

/** Returns the description  of a target. See llvm::Target::getDescription */
public static native @Cast("const char*") BytePointer LLVMGetTargetDescription(LLVMTargetRef T);

/** Returns if the target has a JIT */
public static native @Cast("LLVMBool") int LLVMTargetHasJIT(LLVMTargetRef T);

/** Returns if the target has a TargetMachine associated */
public static native @Cast("LLVMBool") int LLVMTargetHasTargetMachine(LLVMTargetRef T);

/** Returns if the target as an ASM backend (required for emitting output) */
public static native @Cast("LLVMBool") int LLVMTargetHasAsmBackend(LLVMTargetRef T);

/*===-- Target Machine ----------------------------------------------------===*/
/** Creates a new llvm::TargetMachine. See llvm::Target::createTargetMachine */
public static native LLVMTargetMachineRef LLVMCreateTargetMachine(LLVMTargetRef T,
  @Cast("const char*") BytePointer Triple, @Cast("const char*") BytePointer CPU, @Cast("const char*") BytePointer Features,
  @Cast("LLVMCodeGenOptLevel") int Level, @Cast("LLVMRelocMode") int Reloc, @Cast("LLVMCodeModel") int CodeModel);
public static native LLVMTargetMachineRef LLVMCreateTargetMachine(LLVMTargetRef T,
  String Triple, String CPU, String Features,
  @Cast("LLVMCodeGenOptLevel") int Level, @Cast("LLVMRelocMode") int Reloc, @Cast("LLVMCodeModel") int CodeModel);

/** Dispose the LLVMTargetMachineRef instance generated by
  LLVMCreateTargetMachine. */
public static native void LLVMDisposeTargetMachine(LLVMTargetMachineRef T);

/** Returns the Target used in a TargetMachine */
public static native LLVMTargetRef LLVMGetTargetMachineTarget(LLVMTargetMachineRef T);

/** Returns the triple used creating this target machine. See
  llvm::TargetMachine::getTriple. The result needs to be disposed with
  LLVMDisposeMessage. */
public static native @Cast("char*") BytePointer LLVMGetTargetMachineTriple(LLVMTargetMachineRef T);

/** Returns the cpu used creating this target machine. See
  llvm::TargetMachine::getCPU. The result needs to be disposed with
  LLVMDisposeMessage. */
public static native @Cast("char*") BytePointer LLVMGetTargetMachineCPU(LLVMTargetMachineRef T);

/** Returns the feature string used creating this target machine. See
  llvm::TargetMachine::getFeatureString. The result needs to be disposed with
  LLVMDisposeMessage. */
public static native @Cast("char*") BytePointer LLVMGetTargetMachineFeatureString(LLVMTargetMachineRef T);

/** Deprecated: use LLVMGetDataLayout(LLVMModuleRef M) instead. */
public static native LLVMTargetDataRef LLVMGetTargetMachineData(LLVMTargetMachineRef T);

/** Set the target machine's ASM verbosity. */
public static native void LLVMSetTargetMachineAsmVerbosity(LLVMTargetMachineRef T,
                                      @Cast("LLVMBool") int VerboseAsm);

/** Emits an asm or object file for the given module to the filename. This
  wraps several c++ only classes (among them a file stream). Returns any
  error in ErrorMessage. Use LLVMDisposeMessage to dispose the message. */
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToFile(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("char*") BytePointer Filename, @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") PointerPointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToFile(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("char*") BytePointer Filename, @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr BytePointer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToFile(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("char*") ByteBuffer Filename, @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToFile(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("char*") byte[] Filename, @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr byte[] ErrorMessage);

/** Compile the LLVM IR stored in \p M and store the result in \p OutMemBuf. */
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") PointerPointer ErrorMessage, @ByPtrPtr LLVMMemoryBufferRef OutMemBuf);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr BytePointer ErrorMessage, @ByPtrPtr LLVMMemoryBufferRef OutMemBuf);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage, @Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr byte[] ErrorMessage, @ByPtrPtr LLVMMemoryBufferRef OutMemBuf);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr BytePointer ErrorMessage, @Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr ByteBuffer ErrorMessage, @ByPtrPtr LLVMMemoryBufferRef OutMemBuf);
public static native @Cast("LLVMBool") int LLVMTargetMachineEmitToMemoryBuffer(LLVMTargetMachineRef T, LLVMModuleRef M,
  @Cast("LLVMCodeGenFileType") int codegen, @Cast("char**") @ByPtrPtr byte[] ErrorMessage, @Cast("LLVMMemoryBufferRef*") PointerPointer OutMemBuf);

/*===-- Triple ------------------------------------------------------------===*/
/** Get a triple for the host machine as a string. The result needs to be
  disposed with LLVMDisposeMessage. */
public static native @Cast("char*") BytePointer LLVMGetDefaultTargetTriple();

/** Adds the target-specific analysis passes to the pass manager. */
public static native void LLVMAddAnalysisPasses(LLVMTargetMachineRef T, LLVMPassManagerRef PM);

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/ExecutionEngine.h>

/*===-- llvm-c/ExecutionEngine.h - ExecutionEngine Lib C Iface --*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMExecutionEngine.o, which    *|
|* implements various analyses of the LLVM IR.                                *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_EXECUTIONENGINE_H
// #define LLVM_C_EXECUTIONENGINE_H

// #include "llvm-c/Core.h"
// #include "llvm-c/Target.h"
// #include "llvm-c/TargetMachine.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCExecutionEngine Execution Engine
 * @ingroup LLVMC
 *
 * @{
 */

public static native void LLVMLinkInMCJIT();
public static native void LLVMLinkInInterpreter();

@Name("LLVMOpaqueGenericValue") @Opaque public static class LLVMGenericValueRef extends Pointer {
    /** Empty constructor. */
    public LLVMGenericValueRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMGenericValueRef(Pointer p) { super(p); }
}
@Name("LLVMOpaqueExecutionEngine") @Opaque public static class LLVMExecutionEngineRef extends Pointer {
    /** Empty constructor. */
    public LLVMExecutionEngineRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMExecutionEngineRef(Pointer p) { super(p); }
}
@Name("LLVMOpaqueMCJITMemoryManager") @Opaque public static class LLVMMCJITMemoryManagerRef extends Pointer {
    /** Empty constructor. */
    public LLVMMCJITMemoryManagerRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMMCJITMemoryManagerRef(Pointer p) { super(p); }
}

public static class LLVMMCJITCompilerOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public LLVMMCJITCompilerOptions() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public LLVMMCJITCompilerOptions(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMMCJITCompilerOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public LLVMMCJITCompilerOptions position(int position) {
        return (LLVMMCJITCompilerOptions)super.position(position);
    }

  public native @Cast("unsigned") int OptLevel(); public native LLVMMCJITCompilerOptions OptLevel(int OptLevel);
  public native @Cast("LLVMCodeModel") int CodeModel(); public native LLVMMCJITCompilerOptions CodeModel(int CodeModel);
  public native @Cast("LLVMBool") int NoFramePointerElim(); public native LLVMMCJITCompilerOptions NoFramePointerElim(int NoFramePointerElim);
  public native @Cast("LLVMBool") int EnableFastISel(); public native LLVMMCJITCompilerOptions EnableFastISel(int EnableFastISel);
  public native LLVMMCJITMemoryManagerRef MCJMM(); public native LLVMMCJITCompilerOptions MCJMM(LLVMMCJITMemoryManagerRef MCJMM);
}

/*===-- Operations on generic values --------------------------------------===*/

public static native LLVMGenericValueRef LLVMCreateGenericValueOfInt(LLVMTypeRef Ty,
                                                @Cast("unsigned long long") long N,
                                                @Cast("LLVMBool") int IsSigned);

public static native LLVMGenericValueRef LLVMCreateGenericValueOfPointer(Pointer P);

public static native LLVMGenericValueRef LLVMCreateGenericValueOfFloat(LLVMTypeRef Ty, double N);

public static native @Cast("unsigned") int LLVMGenericValueIntWidth(LLVMGenericValueRef GenValRef);

public static native @Cast("unsigned long long") long LLVMGenericValueToInt(LLVMGenericValueRef GenVal,
                                         @Cast("LLVMBool") int IsSigned);

public static native Pointer LLVMGenericValueToPointer(LLVMGenericValueRef GenVal);

public static native double LLVMGenericValueToFloat(LLVMTypeRef TyRef, LLVMGenericValueRef GenVal);

public static native void LLVMDisposeGenericValue(LLVMGenericValueRef GenVal);

/*===-- Operations on execution engines -----------------------------------===*/

public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngineForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutEE,
                                            LLVMModuleRef M,
                                            @Cast("char**") @ByPtrPtr byte[] OutError);

public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreterForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutInterp,
                                        LLVMModuleRef M,
                                        @Cast("char**") @ByPtrPtr byte[] OutError);

public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompilerForModule(@Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT,
                                        LLVMModuleRef M,
                                        @Cast("unsigned") int OptLevel,
                                        @Cast("char**") @ByPtrPtr byte[] OutError);

public static native void LLVMInitializeMCJITCompilerOptions(
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions);

/**
 * Create an MCJIT execution engine for a module, with the given options. It is
 * the responsibility of the caller to ensure that all fields in Options up to
 * the given SizeOfOptions are initialized. It is correct to pass a smaller
 * value of SizeOfOptions that omits some fields. The canonical way of using
 * this is:
 *
 * LLVMMCJITCompilerOptions options;
 * LLVMInitializeMCJITCompilerOptions(&options, sizeof(options));
 * ... fill in those options you care about
 * LLVMCreateMCJITCompilerForModule(&jit, mod, &options, sizeof(options),
 *                                  &error);
 *
 * Note that this is also correct, though possibly suboptimal:
 *
 * LLVMCreateMCJITCompilerForModule(&jit, mod, 0, 0, &error);
 */
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @ByPtrPtr LLVMExecutionEngineRef OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @ByPtrPtr LLVMExecutionEngineRef OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @ByPtrPtr LLVMExecutionEngineRef OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @ByPtrPtr LLVMExecutionEngineRef OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateMCJITCompilerForModule(
  @Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT, LLVMModuleRef M,
  LLVMMCJITCompilerOptions Options, @Cast("size_t") long SizeOfOptions,
  @Cast("char**") @ByPtrPtr byte[] OutError);

/** Deprecated: Use LLVMCreateExecutionEngineForModule instead. */
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@Cast("LLVMExecutionEngineRef*") PointerPointer OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@Cast("LLVMExecutionEngineRef*") PointerPointer OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@ByPtrPtr LLVMExecutionEngineRef OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateExecutionEngine(@Cast("LLVMExecutionEngineRef*") PointerPointer OutEE,
                                   LLVMModuleProviderRef MP,
                                   @Cast("char**") @ByPtrPtr byte[] OutError);

/** Deprecated: Use LLVMCreateInterpreterForModule instead. */
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@Cast("LLVMExecutionEngineRef*") PointerPointer OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@Cast("LLVMExecutionEngineRef*") PointerPointer OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@ByPtrPtr LLVMExecutionEngineRef OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateInterpreter(@Cast("LLVMExecutionEngineRef*") PointerPointer OutInterp,
                               LLVMModuleProviderRef MP,
                               @Cast("char**") @ByPtrPtr byte[] OutError);

/** Deprecated: Use LLVMCreateJITCompilerForModule instead. */
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@ByPtrPtr LLVMExecutionEngineRef OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMCreateJITCompiler(@Cast("LLVMExecutionEngineRef*") PointerPointer OutJIT,
                               LLVMModuleProviderRef MP,
                               @Cast("unsigned") int OptLevel,
                               @Cast("char**") @ByPtrPtr byte[] OutError);

public static native void LLVMDisposeExecutionEngine(LLVMExecutionEngineRef EE);

public static native void LLVMRunStaticConstructors(LLVMExecutionEngineRef EE);

public static native void LLVMRunStaticDestructors(LLVMExecutionEngineRef EE);

public static native int LLVMRunFunctionAsMain(LLVMExecutionEngineRef EE, LLVMValueRef F,
                          @Cast("unsigned") int ArgC, @Cast("const char*const*") PointerPointer ArgV,
                          @Cast("const char*const*") PointerPointer EnvP);
public static native int LLVMRunFunctionAsMain(LLVMExecutionEngineRef EE, LLVMValueRef F,
                          @Cast("unsigned") int ArgC, @Cast("const char*const*") @ByPtrPtr BytePointer ArgV,
                          @Cast("const char*const*") @ByPtrPtr BytePointer EnvP);
public static native int LLVMRunFunctionAsMain(LLVMExecutionEngineRef EE, LLVMValueRef F,
                          @Cast("unsigned") int ArgC, @Cast("const char*const*") @ByPtrPtr ByteBuffer ArgV,
                          @Cast("const char*const*") @ByPtrPtr ByteBuffer EnvP);
public static native int LLVMRunFunctionAsMain(LLVMExecutionEngineRef EE, LLVMValueRef F,
                          @Cast("unsigned") int ArgC, @Cast("const char*const*") @ByPtrPtr byte[] ArgV,
                          @Cast("const char*const*") @ByPtrPtr byte[] EnvP);

public static native LLVMGenericValueRef LLVMRunFunction(LLVMExecutionEngineRef EE, LLVMValueRef F,
                                    @Cast("unsigned") int NumArgs,
                                    @ByPtrPtr LLVMGenericValueRef Args);
public static native LLVMGenericValueRef LLVMRunFunction(LLVMExecutionEngineRef EE, LLVMValueRef F,
                                    @Cast("unsigned") int NumArgs,
                                    @Cast("LLVMGenericValueRef*") PointerPointer Args);

public static native void LLVMFreeMachineCodeForFunction(LLVMExecutionEngineRef EE, LLVMValueRef F);

public static native void LLVMAddModule(LLVMExecutionEngineRef EE, LLVMModuleRef M);

/** Deprecated: Use LLVMAddModule instead. */
public static native void LLVMAddModuleProvider(LLVMExecutionEngineRef EE, LLVMModuleProviderRef MP);

public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @Cast("LLVMModuleRef*") PointerPointer OutMod, @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @Cast("LLVMModuleRef*") PointerPointer OutMod, @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModule(LLVMExecutionEngineRef EE, LLVMModuleRef M,
                          @Cast("LLVMModuleRef*") PointerPointer OutMod, @Cast("char**") @ByPtrPtr byte[] OutError);

/** Deprecated: Use LLVMRemoveModule instead. */
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") PointerPointer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @Cast("LLVMModuleRef*") PointerPointer OutMod, @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") @ByPtrPtr byte[] OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @Cast("LLVMModuleRef*") PointerPointer OutMod, @Cast("char**") @ByPtrPtr BytePointer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @ByPtrPtr LLVMModuleRef OutMod, @Cast("char**") @ByPtrPtr ByteBuffer OutError);
public static native @Cast("LLVMBool") int LLVMRemoveModuleProvider(LLVMExecutionEngineRef EE,
                                  LLVMModuleProviderRef MP,
                                  @Cast("LLVMModuleRef*") PointerPointer OutMod, @Cast("char**") @ByPtrPtr byte[] OutError);

public static native @Cast("LLVMBool") int LLVMFindFunction(LLVMExecutionEngineRef EE, @Cast("const char*") BytePointer Name,
                          @ByPtrPtr LLVMValueRef OutFn);
public static native @Cast("LLVMBool") int LLVMFindFunction(LLVMExecutionEngineRef EE, String Name,
                          @Cast("LLVMValueRef*") PointerPointer OutFn);

public static native Pointer LLVMRecompileAndRelinkFunction(LLVMExecutionEngineRef EE,
                                     LLVMValueRef Fn);

public static native LLVMTargetDataRef LLVMGetExecutionEngineTargetData(LLVMExecutionEngineRef EE);
public static native LLVMTargetMachineRef LLVMGetExecutionEngineTargetMachine(LLVMExecutionEngineRef EE);

public static native void LLVMAddGlobalMapping(LLVMExecutionEngineRef EE, LLVMValueRef Global,
                          Pointer Addr);

public static native Pointer LLVMGetPointerToGlobal(LLVMExecutionEngineRef EE, LLVMValueRef Global);

public static native @Cast("uint64_t") long LLVMGetGlobalValueAddress(LLVMExecutionEngineRef EE, @Cast("const char*") BytePointer Name);
public static native @Cast("uint64_t") long LLVMGetGlobalValueAddress(LLVMExecutionEngineRef EE, String Name);

public static native @Cast("uint64_t") long LLVMGetFunctionAddress(LLVMExecutionEngineRef EE, @Cast("const char*") BytePointer Name);
public static native @Cast("uint64_t") long LLVMGetFunctionAddress(LLVMExecutionEngineRef EE, String Name);

/*===-- Operations on memory managers -------------------------------------===*/

public static class LLVMMemoryManagerAllocateCodeSectionCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMMemoryManagerAllocateCodeSectionCallback(Pointer p) { super(p); }
    protected LLVMMemoryManagerAllocateCodeSectionCallback() { allocate(); }
    private native void allocate();
    public native @Cast("uint8_t*") BytePointer call(
  Pointer Opaque, @Cast("uintptr_t") long Size, @Cast("unsigned") int Alignment, @Cast("unsigned") int SectionID,
  @Cast("const char*") BytePointer SectionName);
}
public static class LLVMMemoryManagerAllocateDataSectionCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMMemoryManagerAllocateDataSectionCallback(Pointer p) { super(p); }
    protected LLVMMemoryManagerAllocateDataSectionCallback() { allocate(); }
    private native void allocate();
    public native @Cast("uint8_t*") BytePointer call(
  Pointer Opaque, @Cast("uintptr_t") long Size, @Cast("unsigned") int Alignment, @Cast("unsigned") int SectionID,
  @Cast("const char*") BytePointer SectionName, @Cast("LLVMBool") int IsReadOnly);
}
public static class LLVMMemoryManagerFinalizeMemoryCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMMemoryManagerFinalizeMemoryCallback(Pointer p) { super(p); }
    protected LLVMMemoryManagerFinalizeMemoryCallback() { allocate(); }
    private native void allocate();
    public native @Cast("LLVMBool") int call(
  Pointer Opaque, @Cast("char**") @ByPtrPtr BytePointer ErrMsg);
}
public static class LLVMMemoryManagerDestroyCallback extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    LLVMMemoryManagerDestroyCallback(Pointer p) { super(p); }
    protected LLVMMemoryManagerDestroyCallback() { allocate(); }
    private native void allocate();
    public native void call(Pointer Opaque);
}

/**
 * Create a simple custom MCJIT memory manager. This memory manager can
 * intercept allocations in a module-oblivious way. This will return NULL
 * if any of the passed functions are NULL.
 *
 * @param Opaque An opaque client object to pass back to the callbacks.
 * @param AllocateCodeSection Allocate a block of memory for executable code.
 * @param AllocateDataSection Allocate a block of memory for data.
 * @param FinalizeMemory Set page permissions and flush cache. Return 0 on
 *   success, 1 on error.
 */
public static native LLVMMCJITMemoryManagerRef LLVMCreateSimpleMCJITMemoryManager(
  Pointer Opaque,
  LLVMMemoryManagerAllocateCodeSectionCallback AllocateCodeSection,
  LLVMMemoryManagerAllocateDataSectionCallback AllocateDataSection,
  LLVMMemoryManagerFinalizeMemoryCallback FinalizeMemory,
  LLVMMemoryManagerDestroyCallback Destroy);

public static native void LLVMDisposeMCJITMemoryManager(LLVMMCJITMemoryManagerRef MM);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* defined(__cplusplus) */

// #endif


// Parsed from <llvm-c/Transforms/IPO.h>

/*===-- IPO.h - Interprocedural Transformations C Interface -----*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMIPO.a, which implements     *|
|* various interprocedural transformations of the LLVM IR.                    *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_TRANSFORMS_IPO_H
// #define LLVM_C_TRANSFORMS_IPO_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCTransformsIPO Interprocedural transformations
 * @ingroup LLVMCTransforms
 *
 * @{
 */

/** See llvm::createArgumentPromotionPass function. */
public static native void LLVMAddArgumentPromotionPass(LLVMPassManagerRef PM);

/** See llvm::createConstantMergePass function. */
public static native void LLVMAddConstantMergePass(LLVMPassManagerRef PM);

/** See llvm::createDeadArgEliminationPass function. */
public static native void LLVMAddDeadArgEliminationPass(LLVMPassManagerRef PM);

/** See llvm::createFunctionAttrsPass function. */
public static native void LLVMAddFunctionAttrsPass(LLVMPassManagerRef PM);

/** See llvm::createFunctionInliningPass function. */
public static native void LLVMAddFunctionInliningPass(LLVMPassManagerRef PM);

/** See llvm::createAlwaysInlinerPass function. */
public static native void LLVMAddAlwaysInlinerPass(LLVMPassManagerRef PM);

/** See llvm::createGlobalDCEPass function. */
public static native void LLVMAddGlobalDCEPass(LLVMPassManagerRef PM);

/** See llvm::createGlobalOptimizerPass function. */
public static native void LLVMAddGlobalOptimizerPass(LLVMPassManagerRef PM);

/** See llvm::createIPConstantPropagationPass function. */
public static native void LLVMAddIPConstantPropagationPass(LLVMPassManagerRef PM);

/** See llvm::createPruneEHPass function. */
public static native void LLVMAddPruneEHPass(LLVMPassManagerRef PM);

/** See llvm::createIPSCCPPass function. */
public static native void LLVMAddIPSCCPPass(LLVMPassManagerRef PM);

/** See llvm::createInternalizePass function. */
public static native void LLVMAddInternalizePass(LLVMPassManagerRef arg0, @Cast("unsigned") int AllButMain);

/** See llvm::createStripDeadPrototypesPass function. */
public static native void LLVMAddStripDeadPrototypesPass(LLVMPassManagerRef PM);

/** See llvm::createStripSymbolsPass function. */
public static native void LLVMAddStripSymbolsPass(LLVMPassManagerRef PM);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* defined(__cplusplus) */

// #endif


// Parsed from <llvm-c/Transforms/PassManagerBuilder.h>

/*===-- llvm-c/Transform/PassManagerBuilder.h - PMB C Interface ---*- C -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to the PassManagerBuilder class.      *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_TRANSFORMS_PASSMANAGERBUILDER_H
// #define LLVM_C_TRANSFORMS_PASSMANAGERBUILDER_H

// #include "llvm-c/Core.h"

@Name("LLVMOpaquePassManagerBuilder") @Opaque public static class LLVMPassManagerBuilderRef extends Pointer {
    /** Empty constructor. */
    public LLVMPassManagerBuilderRef() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LLVMPassManagerBuilderRef(Pointer p) { super(p); }
}

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCTransformsPassManagerBuilder Pass manager builder
 * @ingroup LLVMCTransforms
 *
 * @{
 */

/** See llvm::PassManagerBuilder. */
public static native LLVMPassManagerBuilderRef LLVMPassManagerBuilderCreate();
public static native void LLVMPassManagerBuilderDispose(LLVMPassManagerBuilderRef PMB);

/** See llvm::PassManagerBuilder::OptLevel. */
public static native void LLVMPassManagerBuilderSetOptLevel(LLVMPassManagerBuilderRef PMB,
                                  @Cast("unsigned") int OptLevel);

/** See llvm::PassManagerBuilder::SizeLevel. */
public static native void LLVMPassManagerBuilderSetSizeLevel(LLVMPassManagerBuilderRef PMB,
                                   @Cast("unsigned") int SizeLevel);

/** See llvm::PassManagerBuilder::DisableUnitAtATime. */
public static native void LLVMPassManagerBuilderSetDisableUnitAtATime(LLVMPassManagerBuilderRef PMB,
                                            @Cast("LLVMBool") int Value);

/** See llvm::PassManagerBuilder::DisableUnrollLoops. */
public static native void LLVMPassManagerBuilderSetDisableUnrollLoops(LLVMPassManagerBuilderRef PMB,
                                            @Cast("LLVMBool") int Value);

/** See llvm::PassManagerBuilder::DisableSimplifyLibCalls */
public static native void LLVMPassManagerBuilderSetDisableSimplifyLibCalls(LLVMPassManagerBuilderRef PMB,
                                                 @Cast("LLVMBool") int Value);

/** See llvm::PassManagerBuilder::Inliner. */
public static native void LLVMPassManagerBuilderUseInlinerWithThreshold(LLVMPassManagerBuilderRef PMB,
                                              @Cast("unsigned") int Threshold);

/** See llvm::PassManagerBuilder::populateFunctionPassManager. */
public static native void LLVMPassManagerBuilderPopulateFunctionPassManager(LLVMPassManagerBuilderRef PMB,
                                                  LLVMPassManagerRef PM);

/** See llvm::PassManagerBuilder::populateModulePassManager. */
public static native void LLVMPassManagerBuilderPopulateModulePassManager(LLVMPassManagerBuilderRef PMB,
                                                LLVMPassManagerRef PM);

/** See llvm::PassManagerBuilder::populateLTOPassManager. */
public static native void LLVMPassManagerBuilderPopulateLTOPassManager(LLVMPassManagerBuilderRef PMB,
                                                  LLVMPassManagerRef PM,
                                                  @Cast("LLVMBool") int Internalize,
                                                  @Cast("LLVMBool") int RunInliner);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif

// #endif


// Parsed from <llvm-c/Transforms/Scalar.h>

/*===-- Scalar.h - Scalar Transformation Library C Interface ----*- C++ -*-===*\
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMScalarOpts.a, which         *|
|* implements various scalar transformations of the LLVM IR.                  *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_TRANSFORMS_SCALAR_H
// #define LLVM_C_TRANSFORMS_SCALAR_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCTransformsScalar Scalar transformations
 * @ingroup LLVMCTransforms
 *
 * @{
 */

/** See llvm::createAggressiveDCEPass function. */
public static native void LLVMAddAggressiveDCEPass(LLVMPassManagerRef PM);

/** See llvm::createBitTrackingDCEPass function. */
public static native void LLVMAddBitTrackingDCEPass(LLVMPassManagerRef PM);

/** See llvm::createAlignmentFromAssumptionsPass function. */
public static native void LLVMAddAlignmentFromAssumptionsPass(LLVMPassManagerRef PM);

/** See llvm::createCFGSimplificationPass function. */
public static native void LLVMAddCFGSimplificationPass(LLVMPassManagerRef PM);

/** See llvm::createDeadStoreEliminationPass function. */
public static native void LLVMAddDeadStoreEliminationPass(LLVMPassManagerRef PM);

/** See llvm::createScalarizerPass function. */
public static native void LLVMAddScalarizerPass(LLVMPassManagerRef PM);

/** See llvm::createMergedLoadStoreMotionPass function. */
public static native void LLVMAddMergedLoadStoreMotionPass(LLVMPassManagerRef PM);

/** See llvm::createGVNPass function. */
public static native void LLVMAddGVNPass(LLVMPassManagerRef PM);

/** See llvm::createIndVarSimplifyPass function. */
public static native void LLVMAddIndVarSimplifyPass(LLVMPassManagerRef PM);

/** See llvm::createInstructionCombiningPass function. */
public static native void LLVMAddInstructionCombiningPass(LLVMPassManagerRef PM);

/** See llvm::createJumpThreadingPass function. */
public static native void LLVMAddJumpThreadingPass(LLVMPassManagerRef PM);

/** See llvm::createLICMPass function. */
public static native void LLVMAddLICMPass(LLVMPassManagerRef PM);

/** See llvm::createLoopDeletionPass function. */
public static native void LLVMAddLoopDeletionPass(LLVMPassManagerRef PM);

/** See llvm::createLoopIdiomPass function */
public static native void LLVMAddLoopIdiomPass(LLVMPassManagerRef PM);

/** See llvm::createLoopRotatePass function. */
public static native void LLVMAddLoopRotatePass(LLVMPassManagerRef PM);

/** See llvm::createLoopRerollPass function. */
public static native void LLVMAddLoopRerollPass(LLVMPassManagerRef PM);

/** See llvm::createLoopUnrollPass function. */
public static native void LLVMAddLoopUnrollPass(LLVMPassManagerRef PM);

/** See llvm::createLoopUnswitchPass function. */
public static native void LLVMAddLoopUnswitchPass(LLVMPassManagerRef PM);

/** See llvm::createMemCpyOptPass function. */
public static native void LLVMAddMemCpyOptPass(LLVMPassManagerRef PM);

/** See llvm::createPartiallyInlineLibCallsPass function. */
public static native void LLVMAddPartiallyInlineLibCallsPass(LLVMPassManagerRef PM);

/** See llvm::createLowerSwitchPass function. */
public static native void LLVMAddLowerSwitchPass(LLVMPassManagerRef PM);

/** See llvm::createPromoteMemoryToRegisterPass function. */
public static native void LLVMAddPromoteMemoryToRegisterPass(LLVMPassManagerRef PM);

/** See llvm::createReassociatePass function. */
public static native void LLVMAddReassociatePass(LLVMPassManagerRef PM);

/** See llvm::createSCCPPass function. */
public static native void LLVMAddSCCPPass(LLVMPassManagerRef PM);

/** See llvm::createScalarReplAggregatesPass function. */
public static native void LLVMAddScalarReplAggregatesPass(LLVMPassManagerRef PM);

/** See llvm::createScalarReplAggregatesPass function. */
public static native void LLVMAddScalarReplAggregatesPassSSA(LLVMPassManagerRef PM);

/** See llvm::createScalarReplAggregatesPass function. */
public static native void LLVMAddScalarReplAggregatesPassWithThreshold(LLVMPassManagerRef PM,
                                                  int Threshold);

/** See llvm::createSimplifyLibCallsPass function. */
public static native void LLVMAddSimplifyLibCallsPass(LLVMPassManagerRef PM);

/** See llvm::createTailCallEliminationPass function. */
public static native void LLVMAddTailCallEliminationPass(LLVMPassManagerRef PM);

/** See llvm::createConstantPropagationPass function. */
public static native void LLVMAddConstantPropagationPass(LLVMPassManagerRef PM);

/** See llvm::demotePromoteMemoryToRegisterPass function. */
public static native void LLVMAddDemoteMemoryToRegisterPass(LLVMPassManagerRef PM);

/** See llvm::createVerifierPass function. */
public static native void LLVMAddVerifierPass(LLVMPassManagerRef PM);

/** See llvm::createCorrelatedValuePropagationPass function */
public static native void LLVMAddCorrelatedValuePropagationPass(LLVMPassManagerRef PM);

/** See llvm::createEarlyCSEPass function */
public static native void LLVMAddEarlyCSEPass(LLVMPassManagerRef PM);

/** See llvm::createLowerExpectIntrinsicPass function */
public static native void LLVMAddLowerExpectIntrinsicPass(LLVMPassManagerRef PM);

/** See llvm::createTypeBasedAliasAnalysisPass function */
public static native void LLVMAddTypeBasedAliasAnalysisPass(LLVMPassManagerRef PM);

/** See llvm::createScopedNoAliasAAPass function */
public static native void LLVMAddScopedNoAliasAAPass(LLVMPassManagerRef PM);

/** See llvm::createBasicAliasAnalysisPass function */
public static native void LLVMAddBasicAliasAnalysisPass(LLVMPassManagerRef PM);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* defined(__cplusplus) */

// #endif


// Parsed from <llvm-c/Transforms/Vectorize.h>

/*===---------------------------Vectorize.h --------------------- -*- C -*-===*\
|*===----------- Vectorization Transformation Library C Interface ---------===*|
|*                                                                            *|
|*                     The LLVM Compiler Infrastructure                       *|
|*                                                                            *|
|* This file is distributed under the University of Illinois Open Source      *|
|* License. See LICENSE.TXT for details.                                      *|
|*                                                                            *|
|*===----------------------------------------------------------------------===*|
|*                                                                            *|
|* This header declares the C interface to libLLVMVectorize.a, which          *|
|* implements various vectorization transformations of the LLVM IR.           *|
|*                                                                            *|
|* Many exotic languages can interoperate with C code but have a harder time  *|
|* with C++ due to name mangling. So in addition to C, this interface enables *|
|* tools written in such languages.                                           *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/

// #ifndef LLVM_C_TRANSFORMS_VECTORIZE_H
// #define LLVM_C_TRANSFORMS_VECTORIZE_H

// #include "llvm-c/Core.h"

// #ifdef __cplusplus
// #endif

/**
 * @defgroup LLVMCTransformsVectorize Vectorization transformations
 * @ingroup LLVMCTransforms
 *
 * @{
 */

/** See llvm::createBBVectorizePass function. */
public static native void LLVMAddBBVectorizePass(LLVMPassManagerRef PM);

/** See llvm::createLoopVectorizePass function. */
public static native void LLVMAddLoopVectorizePass(LLVMPassManagerRef PM);

/** See llvm::createSLPVectorizerPass function. */
public static native void LLVMAddSLPVectorizePass(LLVMPassManagerRef PM);

/**
 * @}
 */

// #ifdef __cplusplus
// #endif /* defined(__cplusplus) */

// #endif



}
