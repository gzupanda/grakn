/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016-2018 Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Grakn. If not, see <http://www.gnu.org/licenses/agpl.txt>.
 */

package ai.grakn.graql.analytics;

import ai.grakn.GraknTx;
import ai.grakn.concept.Label;

import java.util.Collection;
import java.util.Optional;

/**
 * Compute the sum of the selected resource-type.
 *
 * @author Jason Liu
 */
public interface SumQuery extends StatisticsQuery<Optional<Number>> {

    /**
     * @param ofTypes an array of types of resources to execute the query on
     * @return a SumQuery with the subTypeLabels set
     */
    @Override
    SumQuery of(String... ofTypes);

    /**
     * @param ofTypes a collection of types of resources to execute the query on
     * @return a SumQuery with the subTypeLabels set
     */
    @Override
    SumQuery of(Collection<Label> ofTypes);

    /**
     * @param inTypes an array of types to include in the subgraph
     * @return a SumQuery with the subTypeLabels set
     */
    @Override
    SumQuery in(String... inTypes);

    /**
     * @param inTypes a collection of types to include in the subgraph
     * @return a SumQuery with the inTypes set
     */
    @Override
    SumQuery in(Collection<? extends Label> inTypes);

    /**
     * Execute the query.
     *
     * @return the sum if the given resource types have instances, otherwise an empty Optional instance
     */
    @Override
    Optional<Number> execute();

    /**
     * @param tx the transaction to execute the query on
     * @return a SumQuery with the transaction set
     */
    @Override
    SumQuery withTx(GraknTx tx);
}
