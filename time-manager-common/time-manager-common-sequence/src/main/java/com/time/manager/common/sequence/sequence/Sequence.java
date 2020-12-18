package com.time.manager.common.sequence.sequence;

import com.time.manager.common.sequence.exception.SeqException;

public interface Sequence {

    long nextSequence() throws SeqException;

}
