package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class Main extends Application {
	int [] counter;
	byte[] value;
	
	 FileInputStream inputStream;
	 HuffmanCoding huffmanCoding = new HuffmanCoding();
	public static String PathName , FileName , PathCompressedFile;
	double sizebefore;
	double sizeafter;
	 double finll;
	 @Override
	public void start(Stage primaryStage) {
            try {
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-image:url('water_ripple-1024x683.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
			GridPane g=new GridPane();
			Label flnum = new Label("File Name");
			flnum.setFont(Font.font(15));
			flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
			g.add(flnum, 0, 0);
			g.setAlignment(Pos.CENTER);
			TextField name=new TextField();
			name.setMinSize(100, 40);
			g.add(name, 0, 1);
			Button bttn =new Button("Browser");
			bttn.setMinHeight(40);
			bttn.setMinWidth(50);
			g.add(bttn, 1, 1);
			Scene scene = new Scene(root,1550,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			bttn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					
					  FileChooser fileChooser = new FileChooser();
				        fileChooser.setTitle("Open Resource File");
				        fileChooser.getExtensionFilters().addAll(
				                new FileChooser.ExtensionFilter("All Files", "*.*")
				        );
				        File selectedFile = fileChooser.showOpenDialog(new Stage());

				        if (selectedFile != null) {

				            FileName = selectedFile.getName();
				            PathName = selectedFile.getAbsolutePath();
				            try {
								sizebefore=Files.size(Paths.get(PathName));
								System.out.print(sizebefore);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				            
				            System.out.print(PathName);
				            Path path = Paths.get(PathName);

				        }


				}
				
			});

			g.setVgap(20);
			g.setHgap(20);
			root.setCenter(g);
			Button btn =new Button("Print Table");
		btn.setFont(Font.font(15));
			btn.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
			btn.setMinHeight(90);
			btn.setMinWidth(300);
			g.add(btn, 0, 4);
			Button compress =new Button("Compress");
			compress.setMinHeight(90);
			compress.setMinWidth(300);
			compress.setFont(Font.font(15));
			compress.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
			g.add(compress, 0, 2);
			Button decompress =new Button("Decompress");
			decompress.setMinHeight(90);
			decompress.setMinWidth(300);
			decompress.setFont(Font.font(15));
			decompress.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
			g.add(decompress, 0, 3);
			Button table =new Button("Table");
			table.setMinHeight(90);
			table.setMinWidth(300);
			table.setFont(Font.font(15));
			table.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
			g.add(table, 0, 4);
		
			Button size =new Button("Size");
			size.setMinHeight(90);
			size.setMinWidth(300);
			size.setFont(Font.font(15));
			size.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
			g.add(size, 0, 5);
		
			size.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane root = new BorderPane();
					root.setStyle("-fx-background-image:url('water_ripple-1024x683.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
					GridPane g=new GridPane();
					ImageView back = new ImageView("backk.png");
					back.setFitWidth(100);
					back.setFitHeight(80);
					Label sizbe=new Label("Size Before:");
					sizbe.setFont(Font.font(25));
					sizbe.setTextFill(Color.BLACK);
					sizbe.setFont(Font.font(null, FontWeight.BOLD, sizbe.getFont().getSize()));
					Label sizee=new Label(String.valueOf(sizebefore));
					sizee.setFont(Font.font(25));
					sizee.setTextFill(Color.BLACK);
					sizee.setFont(Font.font(null, FontWeight.BOLD, sizee.getFont().getSize()));
					g.add(sizbe, 0, 0);
					g.add(sizee, 1, 0);
					Label sizaf=new Label("Size After:");
					sizaf.setFont(Font.font(25));
					sizaf.setTextFill(Color.BLACK);
					sizaf.setFont(Font.font(null, FontWeight.BOLD, sizaf.getFont().getSize()));
					Label aff=new Label(String.valueOf(sizeafter));
					aff.setFont(Font.font(25));
					aff.setTextFill(Color.BLACK);
					aff.setFont(Font.font(null, FontWeight.BOLD, aff.getFont().getSize()));
					g.add(sizaf, 0, 1);
					g.add(aff, 1, 1);
					Label Finn=new Label("Final:");
					Finn.setFont(Font.font(25));
					Finn.setTextFill(Color.BLACK);
					Finn.setFont(Font.font(null, FontWeight.BOLD, Finn.getFont().getSize()));
					
					Label tt=new Label(String.valueOf(finll));
					tt.setFont(Font.font(25));
					tt.setTextFill(Color.BLACK);
					tt.setFont(Font.font(null, FontWeight.BOLD, tt.getFont().getSize()));
					g.add(Finn, 0, 2);
					g.add(tt, 1, 2);
					 g.setVgap(20);
					 g.setHgap(20);
					g.setAlignment(Pos.CENTER);
					root.setCenter(g);
					Button backk = new Button("", back);
					backk.setOnAction(new EventHandler<ActionEvent>() {
				
						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene);

						}

					});
					
					
					root.setAlignment(backk, Pos.CENTER);
					root.setBottom(backk);
					
					//root.setCenter(area);
				
				
					Scene scene = new Scene(root,1550,800);
					primaryStage.setScene(scene);
					primaryStage.show();
					
					
				}
				
				
				
				
				
				
				
				
				
			});
			
			
			
			
			
			
			
			
       compress.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
		
			
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-image:url('water_ripple-1024x683.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
			GridPane g=new GridPane();

		        FileChooser fileChooser = new FileChooser();
	            fileChooser.setTitle("Open Resource File");
	            fileChooser.getExtensionFilters().addAll(
	                    new FileChooser.ExtensionFilter("All Files", "*.huf"));
	            fileChooser.setInitialFileName(FileName);
	            File selectedFile = fileChooser.showSaveDialog(new Stage());
	            if (selectedFile != null) {
	      

	                     PathCompressedFile = selectedFile.getPath();

	                   try {
	                	Countfreq k=new Countfreq();
						k.CountFrequency(PathName);
						
			            Node HuffmanTree = huffmanCoding.HuffmanTreeCoding(k.count,k.value);
			            huffmanCoding.CreateHuffmanCoding(HuffmanTree,"");
			             mainn.compress(k.read, HuffmanTree, PathCompressedFile, huffmanCoding.codes,FileName);
			              Path path = Paths.get(PathCompressedFile);
			                sizeafter=Files.size(path);
			                System.out.println("the final"+sizeafter);
			                 finll=100-((sizeafter/sizebefore)*100);
			                System.out.print("the final"+finll);
							
							
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	         TextArea area = new TextArea();
                area.setPrefHeight(200);
				area.setPrefWidth(500);
	            BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(PathCompressedFile));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                String line;
                try {
					while ((line = reader.readLine()) != null) {
					    area.appendText(line +"\n");
					}
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
				area.setFont(Font.font(15));
				area.setFont(Font.font(null, FontWeight.BOLD, area.getFont().getSize()));
				root.setCenter(area);
				ImageView back = new ImageView("backk.png");
				back.setFitWidth(100);
				back.setFitHeight(80);
				Button backk = new Button("", back);
				backk.setOnAction(new EventHandler<ActionEvent>() {
			
					@Override
					public void handle(ActionEvent arg0) {
						primaryStage.setScene(scene);

					}

				});
				
				
				root.setAlignment(backk, Pos.CENTER);
				root.setBottom(backk);
				
				//root.setCenter(area);
			
			
				Scene scene = new Scene(root,1550,800);
				primaryStage.setScene(scene);
				primaryStage.show();
		}
    	   
	});
       
   	table.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent arg0) {
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-image:url('water_ripple-1024x683.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
			final Label label = new Label("Huffman Tabel ");
			label.setFont(new Font("Arial", 20));
			TableView<Node> table = new TableView<>();
			table.setMaxSize(1000, 800);
			table.setEditable(true);
			TableColumn <Node,String> ch= new TableColumn <Node,String>("Character");
			ch.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getC()));
			ch.setMinWidth(200);
			TableColumn <Node,Integer>fr = new TableColumn<Node,Integer>("Frequency");
			fr.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().freq).asObject());
			fr.setMinWidth(200);
			TableColumn <Node,String>HC = new TableColumn<Node,String>("Huffman Code");
			HC.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().result));
			HC.setPrefWidth(200);
			table.getColumns().addAll(ch, fr, HC);
			ObservableList<Node> data = FXCollections.observableArrayList() ;
			
			
			 for (Node i:huffmanCoding.codes) {
				 data.add(i);
			 }
			 table.setItems(data);
			 root.setCenter(table);
			 ImageView back = new ImageView("backk.png");
				back.setFitWidth(100);
				back.setFitHeight(80);
				Button backk = new Button("", back);
				backk.setOnAction(new EventHandler<ActionEvent>() {
			
					@Override
					public void handle(ActionEvent arg0) {
						primaryStage.setScene(scene);

					}

				});
				
				
				root.setAlignment(backk, Pos.CENTER);
				root.setBottom(backk);

				Scene scene = new Scene(root,1550,800);
				primaryStage.setScene(scene);
				primaryStage.show();
			
			

		
			
		}

	});
	
	
	
	
	
	     
       

       
       
       decompress.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-image:url('water_ripple-1024x683.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1550 800; -fx-background-position: center center;");
			GridPane g=new GridPane();
			 FileChooser fileChooser = new FileChooser();
			 File selected = fileChooser.showOpenDialog(primaryStage);
			
			try {
				mainn.decompress(selected);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			ImageView back = new ImageView("backk.png");
			back.setFitWidth(100);
			back.setFitHeight(80);
			Button backk = new Button("", back);
			backk.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
					primaryStage.setScene(scene);

				}

			});

			root.setAlignment(backk, Pos.CENTER);
			root.setBottom(backk);
			g.setAlignment(Pos.CENTER);
			root.setCenter(g);
		
		
			Scene scene = new Scene(root,1550,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
    	   
	});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
