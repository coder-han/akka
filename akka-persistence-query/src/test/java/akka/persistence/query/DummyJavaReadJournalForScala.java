/*
 * Copyright (C) 2009-2016 Typesafe Inc. <http://www.typesafe.com>
 */

package akka.persistence.query;

import akka.NotUsed;

/**
 * Use for tests only!
 * Emits infinite stream of strings (representing queried for events).
 */
public class DummyJavaReadJournalForScala implements akka.persistence.query.scaladsl.ReadJournal,
    akka.persistence.query.scaladsl.AllPersistenceIdsQuery {

  public static final String Identifier = DummyJavaReadJournal.Identifier;

  private final DummyJavaReadJournal readJournal;

  public DummyJavaReadJournalForScala(DummyJavaReadJournal readJournal) {
    this.readJournal = readJournal;
  }

  @Override
  public akka.stream.scaladsl.Source<String, NotUsed> allPersistenceIds() {
    return readJournal.allPersistenceIds().asScala();
  }

}
