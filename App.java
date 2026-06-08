package com.recommendation;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class App {
    public static void main(String[] args) {
        try {
            // Load data from CSV file (Make sure data.csv is in the project root!)
            File file = new File("C:\\Users\\saipr\\OneDrive\\Desktop\\priya\\recommender-app\\data.csv");
            if (!file.exists()) {
                System.out.println("Error: data.csv not found in " + file.getAbsolutePath());
                return;
            }

            DataModel model = new FileDataModel(file);

            // Calculate similarity between users
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Define neighborhood (Top 2 similar users)
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

            // Create Recommender
            Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Recommend 2 items for User 1
            List<RecommendedItem> recommendations = recommender.recommend(1, 2);

            System.out.println("--- Recommendations for User 1 ---");
            for (RecommendedItem recommendation : recommendations) {
                System.out.println("Recommended Item ID: " + recommendation.getItemID() + 
                                   " (Predicted Rating: " + recommendation.getValue() + ")");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}