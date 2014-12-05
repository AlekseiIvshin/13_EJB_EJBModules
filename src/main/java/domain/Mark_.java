package domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Mark.class)
public class Mark_ {

	public static volatile SingularAttribute<Mark, Long> id;
	public static volatile SingularAttribute<Mark, String> name;
	public static volatile SingularAttribute<Mark, Integer> deleted;
	public static volatile SingularAttribute<Mark, Short> version;
}
