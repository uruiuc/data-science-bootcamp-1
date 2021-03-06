package com.bootcamp.recommendations;
import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

import org.apache.mahout.cf.taste.similarity.UserSimilarity;
public class SimilarUsers
{
    public static void main( String[] args )
    {
        try {
          DataModel model = new FileDataModel(new File("/home/nadine/collaborativenotes/book_ratings2.csv"));
          UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
          UserNeighborhood neighborhood =new NearestNUserNeighborhood(30, similarity, model);
          UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
          long[] mostSimilarUserIDs = recommender.mostSimilarUserIDs(2391563, 10);
          for (long user_id : mostSimilarUserIDs) {
              System.out.println(user_id);
          }
        } catch(Exception e) {
              System.out.println("Error");
              System.out.println(e.getMessage());
        }
    }
}
                                                             
                                                                                                                                                                                   
                                                                                                                                                                                  
