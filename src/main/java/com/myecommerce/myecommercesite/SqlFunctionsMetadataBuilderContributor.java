package com.myecommerce.myecommercesite;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.BooleanType;

public class SqlFunctionsMetadataBuilderContributor implements MetadataBuilderContributor {

    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction("fts",
                new SQLFunctionTemplate(BooleanType.INSTANCE,
                        "document_with_weights @@ plainto_tsquery(?1)"
                ));

        metadataBuilder.applySqlFunction("rank",
                new SQLFunctionTemplate(BooleanType.INSTANCE,
                        "ts_rank(document_with_weights, plainto_tsquery(?1))"
                ));
    }
}
