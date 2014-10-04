/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hydromatic.optiq.materialize;

import org.eigenbase.util.Util;

import com.google.common.collect.ImmutableList;

import java.util.BitSet;

/** Definition of a particular combination of dimensions and measures of a
 * lattice that is the basis of a materialization.
 *
 * <p>Holds similar information to a
 * {@link net.hydromatic.optiq.materialize.Lattice.Tile} but a lattice is
 * immutable and tiles are not added after their creation. */
public class TileKey {
  public final Lattice lattice;
  public final BitSet dimensions;
  public final ImmutableList<Lattice.Measure> measures;

  /** Creates a TileKey. */
  public TileKey(Lattice lattice, BitSet dimensions,
      ImmutableList<Lattice.Measure> measures) {
    this.lattice = lattice;
    this.dimensions = dimensions;
    this.measures = measures;
  }

  @Override public int hashCode() {
    return Util.hashV(lattice, dimensions);
  }

  @Override public boolean equals(Object obj) {
    return obj == this
        || obj instanceof TileKey
        && lattice == ((TileKey) obj).lattice
        && dimensions.equals(((TileKey) obj).dimensions)
        && measures.equals(((TileKey) obj).measures);
  }
}

// End TileKey.java
