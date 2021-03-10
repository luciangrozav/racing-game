package org.fasttrackit.persistency;

public interface RankingsRepository {

    void addRankingItem(int rank, String competitorName, double TotalDistance);

        void close();

}
