from django.shortcuts import render, get_object_or_404
from .models import SingleSoil
import logging

# Set up the logger
logger = logging.getLogger(__name__)


def single_soil(request, id):
    # Fetch the SingleSoil instance for the given id
    soil = get_object_or_404(SingleSoil, pk=id)

    # Fetch all plants associated with the SingleSoil instance
    plants = soil.plants.all()

    # Log the plants QuerySet
    logger.info('Plants QuerySet: %s', plants)

    # For more detailed logging of each plant's name
    for plant in plants:
        logger.info('Plant Name: %s', plant.name)

    # Pass both the soil instance and the list of plants to the template
    return render(request, 'soil_detail.html', {'soil': soil, 'plants': plants})
